package net.hemisoft.p2p.importer.plattform.viventor

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
public class ViventorConfiguration {
	final JobBuilderFactory  jobBuilderFactory
	final StepBuilderFactory stepBuilderFactory

	ViventorConfiguration(JobBuilderFactory  jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource viventorResource(@Value('${path.viventor.input}') def path) {
		new FileSystemResource(path)
	}

	// Reader, Processor and Writer ...
	
	@Bean
	ItemReader viventorItemReader(Resource viventorResource) {
		ViventorItemReader.newInstance viventorResource
	}

	@Bean
	ItemProcessor viventorItemProcessor() {
		new ViventorItemProcessor()
	}
	
	@Bean
	ItemWriter viventorItemWriter() {
		new ViventorItemWriter()
	}
	
	// Job steps
	
	@Bean
	Job viventorImportJob(JobExecutionListener viventorJobCompletionNotificationListener, Step importViventorDataStep) {
		jobBuilderFactory.get("viventorImportJob")
			.incrementer(RunIdIncrementer.newInstance())
			.listener(viventorJobCompletionNotificationListener)
			.flow(importViventorDataStep)
			.end()
			.build()
	}
	
	@Bean
	Step importViventorDataStep(ItemReader viventorItemReader, ItemProcessor viventorItemProcessor, ItemWriter viventorItemWriter) {
		stepBuilderFactory.get("step1")
			.<ViventorTransactionDto, TransactionEntity> chunk(10)
			.reader(viventorItemReader)
			.processor(viventorItemProcessor)
			.writer(viventorItemWriter)
			.build()
	}
	
	@Bean
	JobExecutionListener viventorJobCompletionNotificationListener() {
		ViventorJobCompletionNotificationListener.newInstance()
	}
}
