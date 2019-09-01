package net.hemisoft.p2p.importer.plattform.twino

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobExecutionListener
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.Resource

import net.hemisoft.p2p.importer.domain.TransactionEntity

@Configuration
@EnableBatchProcessing
public class TwinoConfiguration {
	final JobBuilderFactory  jobBuilderFactory
	final StepBuilderFactory stepBuilderFactory

	TwinoConfiguration(JobBuilderFactory  jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource twinoResource(@Value('${path.twino.input}') def path) {
		new FileSystemResource(path)
	}

	// Reader, Processor and Writer ...
	
	@Bean
	ItemReader twinoItemReader(Resource twinoResource) {
		TwinoItemReader.newInstance twinoResource
	}

	@Bean
	ItemProcessor twinoItemProcessor() {
		new TwinoItemProcessor()
	}
	
	@Bean
	ItemWriter twinoItemWriter() {
		new TwinoItemWriter()
	}
	
	// Job steps
	
	@Bean
	Job twinoImportJob(JobExecutionListener twinoJobCompletionNotificationListener, Step importTwinoDataStep) {
		jobBuilderFactory.get("twinoImportJob")
			.incrementer(RunIdIncrementer.newInstance())
			.listener(twinoJobCompletionNotificationListener)
			.flow(importTwinoDataStep)
			.end()
			.build()
	}
	
	@Bean
	Step importTwinoDataStep(ItemReader twinoItemReader, ItemProcessor twinoItemProcessor, ItemWriter twinoItemWriter) {
		stepBuilderFactory.get("step1")
			.<TwinoTransactionDto, TransactionEntity> chunk(10)
			.reader(twinoItemReader)
			.processor(twinoItemProcessor)
			.writer(twinoItemWriter)
			.build()
	}
	
	@Bean
	JobExecutionListener twinoJobCompletionNotificationListener() {
		TwinoJobCompletionNotificationListener.newInstance()
	}
}
