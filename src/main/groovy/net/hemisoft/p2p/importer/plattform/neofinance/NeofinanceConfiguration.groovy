package net.hemisoft.p2p.importer.plattform.neofinance

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
public class NeofinanceConfiguration {
	final JobBuilderFactory  jobBuilderFactory
	final StepBuilderFactory stepBuilderFactory

	NeofinanceConfiguration(JobBuilderFactory  jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource neofinanceResource(@Value('${path.neofinance.input}') def path) {
		new FileSystemResource(path)
	}

	// Reader, Processor and Writer ...
	
	@Bean
	ItemReader neofinanceItemReader(Resource neofinanceResource) {
		NeofinanceItemReader.newInstance neofinanceResource
	}

	@Bean
	ItemProcessor neofinanceItemProcessor() {
		new NeofinanceItemProcessor()
	}
	
	@Bean
	ItemWriter neofinanceItemWriter() {
		new NeofinanceItemWriter()
	}
	
	// Job steps
	
	@Bean
	Job neofinanceImportJob(JobExecutionListener neofinanceJobCompletionNotificationListener, Step importNeofinanceDataStep) {
		jobBuilderFactory.get("neofinanceImportJob")
			.incrementer(RunIdIncrementer.newInstance())
			.listener(neofinanceJobCompletionNotificationListener)
			.flow(importNeofinanceDataStep)
			.end()
			.build()
	}
	
	@Bean
	Step importNeofinanceDataStep(ItemReader neofinanceItemReader, ItemProcessor neofinanceItemProcessor, ItemWriter neofinanceItemWriter) {
		stepBuilderFactory.get("step1")
			.<NeofinanceTransactionDto, TransactionEntity> chunk(10)
			.reader(neofinanceItemReader)
			.processor(neofinanceItemProcessor)
			.writer(neofinanceItemWriter)
			.build()
	}
	
	@Bean
	JobExecutionListener neofinanceJobCompletionNotificationListener() {
		NeofinanceJobCompletionNotificationListener.newInstance()
	}
}
