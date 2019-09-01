package net.hemisoft.p2p.importer.plattform.estateguru

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
public class EstateguruConfiguration {
	final JobBuilderFactory  jobBuilderFactory
	final StepBuilderFactory stepBuilderFactory

	EstateguruConfiguration(JobBuilderFactory  jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource estateguruResource(@Value('${path.estateguru.input}') def path) {
		new FileSystemResource(path)
	}

	// Reader, Processor and Writer ...
	
	@Bean
	ItemReader estateguruItemReader(Resource estateguruResource) {
		EstateguruItemReader.newInstance estateguruResource
	}

	@Bean
	ItemProcessor estateguruItemProcessor() {
		new EstateguruItemProcessor()
	}
	
	@Bean
	ItemWriter estateguruItemWriter() {
		new EstateguruItemWriter()
	}
	
	// Job steps
	
	@Bean
	Job estateguruImportJob(JobExecutionListener estateguruJobCompletionNotificationListener, Step importEstateguruDataStep) {
		jobBuilderFactory.get("estateguruImportJob")
			.incrementer(RunIdIncrementer.newInstance())
			.listener(estateguruJobCompletionNotificationListener)
			.flow(importEstateguruDataStep)
			.end()
			.build()
	}
	
	@Bean
	Step importEstateguruDataStep(ItemReader estateguruItemReader, ItemProcessor estateguruItemProcessor, ItemWriter estateguruItemWriter) {
		stepBuilderFactory.get("step1")
			.<EstateguruTransactionDto, TransactionEntity> chunk(10)
			.reader(estateguruItemReader)
			.processor(estateguruItemProcessor)
			.writer(estateguruItemWriter)
			.build()
	}
	
	@Bean
	JobExecutionListener estateguruJobCompletionNotificationListener() {
		EstateguruJobCompletionNotificationListener.newInstance()
	}
}
