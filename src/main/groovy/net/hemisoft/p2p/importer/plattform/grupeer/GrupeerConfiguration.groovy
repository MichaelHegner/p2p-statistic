package net.hemisoft.p2p.importer.plattform.grupeer

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
public class GrupeerConfiguration {
	final JobBuilderFactory  jobBuilderFactory
	final StepBuilderFactory stepBuilderFactory

	GrupeerConfiguration(JobBuilderFactory  jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource grupeerResource(@Value('${path.grupeer.input}') def path) {
		new FileSystemResource(path)
	}

	// Reader, Processor and Writer ...
	
	@Bean
	ItemReader grupeerItemReader(Resource grupeerResource) {
		GrupeerItemReader.newInstance grupeerResource
	}

	@Bean
	ItemProcessor grupeerItemProcessor() {
		new GrupeerItemProcessor()
	}
	
	@Bean
	ItemWriter grupeerItemWriter() {
		new GrupeerItemWriter()
	}
	
	// Job steps
	
	@Bean
	Job grupeerImportJob(JobExecutionListener grupeerJobCompletionNotificationListener, Step importGrupeerDataStep) {
		jobBuilderFactory.get("grupeerImportJob")
			.incrementer(RunIdIncrementer.newInstance())
			.listener(grupeerJobCompletionNotificationListener)
			.flow(importGrupeerDataStep)
			.end()
			.build()
	}
	
	@Bean
	Step importGrupeerDataStep(ItemReader grupeerItemReader, ItemProcessor grupeerItemProcessor, ItemWriter grupeerItemWriter) {
		stepBuilderFactory.get("step1")
			.<GrupeerTransactionDto, TransactionEntity> chunk(10)
			.reader(grupeerItemReader)
			.processor(grupeerItemProcessor)
			.writer(grupeerItemWriter)
			.build()
	}
	
	@Bean
	JobExecutionListener grupeerJobCompletionNotificationListener() {
		GrupeerJobCompletionNotificationListener.newInstance()
	}
}
