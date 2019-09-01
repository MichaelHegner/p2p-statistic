package net.hemisoft.p2p.importer.investly

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
public class InvestlyConfiguration {
	final JobBuilderFactory  jobBuilderFactory
	final StepBuilderFactory stepBuilderFactory

	InvestlyConfiguration(JobBuilderFactory  jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource investlyResource(@Value('${path.investly.input}') def path) {
		new FileSystemResource(path)
	}

	// Reader, Processor and Writer ...
	
	@Bean
	ItemReader investlyItemReader(Resource investlyResource) {
		InvestlyItemReader.newInstance investlyResource
	}

	@Bean
	ItemProcessor investlyItemProcessor() {
		new InvestlyItemProcessor()
	}
	
	@Bean
	ItemWriter investlyItemWriter() {
		new InvestlyItemWriter()
	}
	
	// Job steps
	
	@Bean
	Job investlyImportJob(JobExecutionListener investlyJobCompletionNotificationListener, Step importInvestlyDataStep) {
		jobBuilderFactory.get("investlyImportJob")
			.incrementer(RunIdIncrementer.newInstance())
			.listener(investlyJobCompletionNotificationListener)
			.flow(importInvestlyDataStep)
			.end()
			.build()
	}
	
	@Bean
	Step importInvestlyDataStep(ItemReader investlyItemReader, ItemProcessor investlyItemProcessor, ItemWriter investlyItemWriter) {
		stepBuilderFactory.get("step1")
			.<InvestlyTransactionDto, TransactionEntity> chunk(10)
			.reader(investlyItemReader)
			.processor(investlyItemProcessor)
			.writer(investlyItemWriter)
			.build()
	}
	
	@Bean
	JobExecutionListener investlyJobCompletionNotificationListener() {
		InvestlyJobCompletionNotificationListener.newInstance()
	}
}
