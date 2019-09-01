package net.hemisoft.p2p.importer.robocash

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
public class RobocashConfiguration {
	final JobBuilderFactory  jobBuilderFactory
	final StepBuilderFactory stepBuilderFactory

	RobocashConfiguration(JobBuilderFactory  jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource robocashResource(@Value('${path.robocash.input}') def path) {
		new FileSystemResource(path)
	}

	// Reader, Processor and Writer ...
	
	@Bean
	ItemReader robocashItemReader(Resource robocashResource) {
		RobocashItemReader.newInstance robocashResource
	}

	@Bean
	ItemProcessor robocashItemProcessor() {
		new RobocashItemProcessor()
	}
	
	@Bean
	ItemWriter robocashItemWriter() {
		new RobocashItemWriter()
	}
	
	// Job steps
	
	@Bean
	Job robocashImportJob(JobExecutionListener robocashJobCompletionNotificationListener, Step importRobocashDataStep) {
		jobBuilderFactory.get("robocashImportJob")
			.incrementer(RunIdIncrementer.newInstance())
			.listener(robocashJobCompletionNotificationListener)
			.flow(importRobocashDataStep)
			.end()
			.build()
	}
	
	@Bean
	Step importRobocashDataStep(ItemReader robocashItemReader, ItemProcessor robocashItemProcessor, ItemWriter robocashItemWriter) {
		stepBuilderFactory.get("step1")
			.<RobocashTransactionDto, TransactionEntity> chunk(10)
			.reader(robocashItemReader)
			.processor(robocashItemProcessor)
			.writer(robocashItemWriter)
			.build()
	}
	
	@Bean
	JobExecutionListener robocashJobCompletionNotificationListener() {
		RobocashJobCompletionNotificationListener.newInstance()
	}
}
