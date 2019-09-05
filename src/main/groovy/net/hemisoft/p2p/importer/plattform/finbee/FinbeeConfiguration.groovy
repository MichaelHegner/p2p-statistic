package net.hemisoft.p2p.importer.plattform.finbee

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
public class FinbeeConfiguration {
	private final StepBuilderFactory stepBuilderFactory
	
	FinbeeConfiguration(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource finbeeResource(@Value('${path.finbee.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	ItemReader finbeeItemReader(Resource finbeeResource) {
		FinbeeItemReader.newInstance finbeeResource
	}

	@Bean
	ItemProcessor finbeeItemProcessor() {
		new FinbeeItemProcessor()
	}
	
	@Bean
	ItemWriter finbeeItemWriter() {
		new FinbeeItemWriter()
	}
	
	
	@Bean
	Step importFinbeeDataStep(
		ItemReader finbeeItemReader, 
		ItemProcessor finbeeItemProcessor, 
		ItemWriter finbeeItemWriter,
		StepExecutionListener finbeeStepExecutionListener
	) {
		stepBuilderFactory.get("importFinbeeData").listener(finbeeStepExecutionListener)
			.<FinbeeTransactionDto, TransactionEntity> chunk(10)
			.reader(finbeeItemReader)
			.processor(finbeeItemProcessor)
			.writer(finbeeItemWriter)
			.build()
	}
	
	@Bean
	StepExecutionListener finbeeStepExecutionListener() {
		new FinbeeStepExecutionListener()
	}
}
