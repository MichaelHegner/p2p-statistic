package net.hemisoft.p2p.importer.plattform.viventor

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
public class ViventorConfiguration {
	private final StepBuilderFactory stepBuilderFactory
	
	ViventorConfiguration(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource viventorResource(@Value('${path.viventor.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	ItemReader viventorItemReader(Resource viventorResource) {
		ViventorItemReader.newInstance viventorResource
	}

	@Bean
	ItemProcessor viventorItemProcessor() {
		new ViventorItemProcessor()
	}
	
	@Bean
	ItemWriter viventorItemWriter() {
		new ViventorItemWriter()
	}
	
	
	@Bean
	Step importViventorDataStep(
		ItemReader viventorItemReader, 
		ItemProcessor viventorItemProcessor, 
		ItemWriter viventorItemWriter,
		StepExecutionListener viventorStepExecutionListener
	) {
		stepBuilderFactory.get("importViventorData").listener(viventorStepExecutionListener)
			.<ViventorTransactionDto, TransactionEntity> chunk(10)
			.reader(viventorItemReader)
			.processor(viventorItemProcessor)
			.writer(viventorItemWriter)
			.build()
	}
	
	@Bean
	StepExecutionListener viventorStepExecutionListener() {
		new ViventorStepExecutionListener()
	}
}
