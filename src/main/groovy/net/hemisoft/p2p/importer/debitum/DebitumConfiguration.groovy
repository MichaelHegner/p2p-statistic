package net.hemisoft.p2p.importer.debitum

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
public class DebitumConfiguration {
	final JobBuilderFactory  jobBuilderFactory
	final StepBuilderFactory stepBuilderFactory

	DebitumConfiguration(JobBuilderFactory  jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource debitumResource(@Value('${path.debitum.input}') def path) {
		new FileSystemResource(path)
	}

	// Reader, Processor and Writer ...
	
	@Bean
	ItemReader debitumItemReader(Resource debitumResource) {
		DebitumItemReader.newInstance debitumResource
	}

	@Bean
	ItemProcessor debitumItemProcessor() {
		new DebitumItemProcessor()
	}
	
	@Bean
	ItemWriter debitumItemWriter() {
		new DebitumItemWriter()
	}
	
	// Job steps
	
	@Bean
	Job debitumImportJob(JobExecutionListener debitumJobCompletionNotificationListener, Step importDebitumDataStep) {
		jobBuilderFactory.get("debitumImportJob")
			.incrementer(RunIdIncrementer.newInstance())
			.listener(debitumJobCompletionNotificationListener)
			.flow(importDebitumDataStep)
			.end()
			.build()
	}
	
	@Bean
	Step importDebitumDataStep(ItemReader debitumItemReader, ItemProcessor debitumItemProcessor, ItemWriter debitumItemWriter) {
		stepBuilderFactory.get("step1")
			.<DebitumTransactionDto, TransactionEntity> chunk(10)
			.reader(debitumItemReader)
			.processor(debitumItemProcessor)
			.writer(debitumItemWriter)
			.build()
	}
	
	@Bean
	JobExecutionListener debitumJobCompletionNotificationListener() {
		DebitumJobCompletionNotificationListener.newInstance()
	}
}
