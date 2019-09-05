package net.hemisoft.p2p.importer.plattform.flender

import org.springframework.batch.core.Step
import org.springframework.batch.core.StepExecutionListener
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
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
	private final StepBuilderFactory stepBuilderFactory
	
	FlenderConfiguration(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource flenderResource(@Value('${path.flender.input}') def path) {
		new FileSystemResource(path)
	}

	
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
	
	
	@Bean
	Step importFlenderDataStep(
		ItemReader flenderItemReader, 
		ItemProcessor flenderItemProcessor, 
		ItemWriter flenderItemWriter,
		StepExecutionListener flenderStepExecutionListener
	) {
		stepBuilderFactory.get("importFlenderData").listener(flenderStepExecutionListener)
			.<FlenderTransactionDto, TransactionEntity> chunk(10)
			.reader(flenderItemReader)
			.processor(flenderItemProcessor)
			.writer(flenderItemWriter)
			.build()
	}
	
	@Bean
	StepExecutionListener flenderStepExecutionListener() {
		new FlenderStepExecutionListener()
	}
}
