package net.hemisoft.p2p.importer.swaper

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
public class SwaperConfiguration {
	final JobBuilderFactory  jobBuilderFactory
	final StepBuilderFactory stepBuilderFactory

	SwaperConfiguration(JobBuilderFactory  jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource swaperResource(@Value('${path.swaper.input}') def path) {
		new FileSystemResource(path)
	}

	// Reader, Processor and Writer ...
	
	@Bean
	ItemReader swaperItemReader(Resource swaperResource) {
		SwaperItemReader.newInstance swaperResource
	}

	@Bean
	ItemProcessor swaperItemProcessor() {
		new SwaperItemProcessor()
	}
	
	@Bean
	ItemWriter swaperItemWriter() {
		new SwaperItemWriter()
	}
	
	// Job steps
	
	@Bean
	Job swaperImportJob(JobExecutionListener swaperJobCompletionNotificationListener, Step importSwaperDataStep) {
		jobBuilderFactory.get("swaperImportJob")
			.incrementer(RunIdIncrementer.newInstance())
			.listener(swaperJobCompletionNotificationListener)
			.flow(importSwaperDataStep)
			.end()
			.build()
	}
	
	@Bean
	Step importSwaperDataStep(ItemReader swaperItemReader, ItemProcessor swaperItemProcessor, ItemWriter swaperItemWriter) {
		stepBuilderFactory.get("step1")
			.<SwaperTransactionDto, TransactionEntity> chunk(10)
			.reader(swaperItemReader)
			.processor(swaperItemProcessor)
			.writer(swaperItemWriter)
			.build()
	}
	
	@Bean
	JobExecutionListener swaperJobCompletionNotificationListener() {
		SwaperJobCompletionNotificationListener.newInstance()
	}
}
