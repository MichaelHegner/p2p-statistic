package net.hemisoft.p2p.importer.plattform.twino

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
public class TwinoConfiguration {
	private final StepBuilderFactory stepBuilderFactory
	
	TwinoConfiguration(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource twinoResource(@Value('${path.twino.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	ItemReader twinoItemReader(Resource twinoResource) {
		TwinoItemReader.newInstance twinoResource
	}

	@Bean
	ItemProcessor twinoItemProcessor() {
		new TwinoItemProcessor()
	}
	
	@Bean
	ItemWriter twinoItemWriter() {
		new TwinoItemWriter()
	}
	
	
	@Bean
	Step importTwinoDataStep(
		ItemReader twinoItemReader, 
		ItemProcessor twinoItemProcessor, 
		ItemWriter twinoItemWriter,
		StepExecutionListener twinoStepExecutionListener
	) {
		stepBuilderFactory.get("importTwinoData").listener(twinoStepExecutionListener)
			.<TwinoTransactionDto, TransactionEntity> chunk(10)
			.reader(twinoItemReader)
			.processor(twinoItemProcessor)
			.writer(twinoItemWriter)
			.build()
	}
	
	@Bean
	StepExecutionListener twinoStepExecutionListener() {
		new TwinoStepExecutionListener()
	}
}
