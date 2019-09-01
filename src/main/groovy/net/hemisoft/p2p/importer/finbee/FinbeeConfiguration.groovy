package net.hemisoft.p2p.importer.finbee

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
public class FinbeeConfiguration {
	final JobBuilderFactory  jobBuilderFactory
	final StepBuilderFactory stepBuilderFactory

	FinbeeConfiguration(JobBuilderFactory  jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource finbeeResource(@Value('${path.finbee.input}') def path) {
		new FileSystemResource(path)
	}

	// Reader, Processor and Writer ...
	
	@Bean
	ItemReader finbeeItemReader(Resource finbeeResource) {
		FinbeeItemReader.newInstance finbeeResource
	}

	@Bean
	ItemProcessor finbeeItemProcessor() {
		new FinbeeItemProcessor()
	}
	
	@Bean
	ItemWriter finbeeItemWriter() {
		new FinbeeItemWriter()
	}
	
	// Job steps
	
	@Bean
	Job finbeeImportJob(JobExecutionListener finbeeJobCompletionNotificationListener, Step importFinbeeDataStep) {
		jobBuilderFactory.get("finbeeImportJob")
			.incrementer(RunIdIncrementer.newInstance())
			.listener(finbeeJobCompletionNotificationListener)
			.flow(importFinbeeDataStep)
			.end()
			.build()
	}
	
	@Bean
	Step importFinbeeDataStep(ItemReader finbeeItemReader, ItemProcessor finbeeItemProcessor, ItemWriter finbeeItemWriter) {
		stepBuilderFactory.get("step1")
			.<FinbeeTransactionDto, TransactionEntity> chunk(10)
			.reader(finbeeItemReader)
			.processor(finbeeItemProcessor)
			.writer(finbeeItemWriter)
			.build()
	}
	
	@Bean
	JobExecutionListener finbeeJobCompletionNotificationListener() {
		FinbeeJobCompletionNotificationListener.newInstance()
	}
}
