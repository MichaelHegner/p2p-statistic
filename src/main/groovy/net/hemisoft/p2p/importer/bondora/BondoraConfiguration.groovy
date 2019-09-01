package net.hemisoft.p2p.importer.bondora

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
public class BondoraConfiguration {
	final JobBuilderFactory  jobBuilderFactory
	final StepBuilderFactory stepBuilderFactory

	BondoraConfiguration(JobBuilderFactory  jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource bondoraResource(@Value('${path.bondora.input}') def path) {
		new FileSystemResource(path)
	}

	// Reader, Processor and Writer ...
	
	@Bean
	ItemReader bondoraItemReader(Resource bondoraResource) {
		BondoraItemReader.newInstance bondoraResource
	}

	@Bean
	ItemProcessor bondoraItemProcessor() {
		new BondoraItemProcessor()
	}
	
	@Bean
	ItemWriter bondoraItemWriter() {
		new BondoraItemWriter()
	}
	
	// Job steps
	
	@Bean
	Job bondoraImportJob(JobExecutionListener bondoraJobCompletionNotificationListener, Step importBondoraDataStep) {
		jobBuilderFactory.get("bondoraImportJob")
			.incrementer(RunIdIncrementer.newInstance())
			.listener(bondoraJobCompletionNotificationListener)
			.flow(importBondoraDataStep)
			.end()
			.build()
	}
	
	@Bean
	Step importBondoraDataStep(ItemReader bondoraItemReader, ItemProcessor bondoraItemProcessor, ItemWriter bondoraItemWriter) {
		stepBuilderFactory.get("step1")
			.<BondoraTransactionDto, TransactionEntity> chunk(10)
			.reader(bondoraItemReader)
			.processor(bondoraItemProcessor)
			.writer(bondoraItemWriter)
			.build()
	}
	
	@Bean
	JobExecutionListener bondoraJobCompletionNotificationListener() {
		BondoraJobCompletionNotificationListener.newInstance()
	}
}
