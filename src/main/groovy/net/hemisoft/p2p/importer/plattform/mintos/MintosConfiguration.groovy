package net.hemisoft.p2p.importer.plattform.mintos

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
public class MintosConfiguration {
	final JobBuilderFactory  jobBuilderFactory
	final StepBuilderFactory stepBuilderFactory

	MintosConfiguration(JobBuilderFactory  jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource mintosResource(@Value('${path.mintos.input}') def path) {
		new FileSystemResource(path)
	}

	// Reader, Processor and Writer ...
	
	@Bean
	ItemReader mintosItemReader(Resource mintosResource) {
		MintosItemReader.newInstance mintosResource
	}

	@Bean
	ItemProcessor mintosItemProcessor() {
		new MintosItemProcessor()
	}
	
	@Bean
	ItemWriter mintosItemWriter() {
		new MintosItemWriter()
	}
	
	// Job steps
	
	@Bean
	Job mintosImportJob(JobExecutionListener mintosJobCompletionNotificationListener, Step importMintosDataStep) {
		jobBuilderFactory.get("mintosImportJob")
			.incrementer(RunIdIncrementer.newInstance())
			.listener(mintosJobCompletionNotificationListener)
			.flow(importMintosDataStep)
			.end()
			.build()
	}
	
	@Bean
	Step importMintosDataStep(ItemReader mintosItemReader, ItemProcessor mintosItemProcessor, ItemWriter mintosItemWriter) {
		stepBuilderFactory.get("step1")
			.<MintosTransactionDto, TransactionEntity> chunk(10)
			.reader(mintosItemReader)
			.processor(mintosItemProcessor)
			.writer(mintosItemWriter)
			.build()
	}
	
	@Bean
	JobExecutionListener mintosJobCompletionNotificationListener() {
		MintosJobCompletionNotificationListener.newInstance()
	}
}
