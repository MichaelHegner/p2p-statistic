package net.hemisoft.p2p.importer.plattform.flender

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
public class FlenderConfiguration {
	final JobBuilderFactory  jobBuilderFactory
	final StepBuilderFactory stepBuilderFactory

	FlenderConfiguration(JobBuilderFactory  jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource flenderResource(@Value('${path.flender.input}') def path) {
		new FileSystemResource(path)
	}

	// Reader, Processor and Writer ...
	
	@Bean
	ItemReader flenderItemReader(Resource flenderResource) {
		FlenderItemReader.newInstance flenderResource
	}

	@Bean
	ItemProcessor flenderItemProcessor() {
		new FlenderItemProcessor()
	}
	
	@Bean
	ItemWriter flenderItemWriter() {
		new FlenderItemWriter()
	}
	
	// Job steps
	
	@Bean
	Job flenderImportJob(JobExecutionListener flenderJobCompletionNotificationListener, Step importFlenderDataStep) {
		jobBuilderFactory.get("flenderImportJob")
			.incrementer(RunIdIncrementer.newInstance())
			.listener(flenderJobCompletionNotificationListener)
			.flow(importFlenderDataStep)
			.end()
			.build()
	}
	
	@Bean
	Step importFlenderDataStep(ItemReader flenderItemReader, ItemProcessor flenderItemProcessor, ItemWriter flenderItemWriter) {
		stepBuilderFactory.get("step1")
			.<FlenderTransactionDto, TransactionEntity> chunk(10)
			.reader(flenderItemReader)
			.processor(flenderItemProcessor)
			.writer(flenderItemWriter)
			.build()
	}
	
	@Bean
	JobExecutionListener flenderJobCompletionNotificationListener() {
		FlenderJobCompletionNotificationListener.newInstance()
	}
}
