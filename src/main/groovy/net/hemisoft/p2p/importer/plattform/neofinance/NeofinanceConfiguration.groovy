package net.hemisoft.p2p.importer.plattform.neofinance

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
public class NeofinanceConfiguration {
	private final StepBuilderFactory stepBuilderFactory
	
	NeofinanceConfiguration(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource neofinanceResource(@Value('${path.neofinance.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	ItemReader neofinanceItemReader(Resource neofinanceResource) {
		NeofinanceItemReader.newInstance neofinanceResource
	}

	@Bean
	ItemProcessor neofinanceItemProcessor() {
		new NeofinanceItemProcessor()
	}
	
	@Bean
	ItemWriter neofinanceItemWriter() {
		new NeofinanceItemWriter()
	}
	
	
	@Bean
	Step importNeofinanceDataStep(
		ItemReader neofinanceItemReader, 
		ItemProcessor neofinanceItemProcessor, 
		ItemWriter neofinanceItemWriter,
		StepExecutionListener neofinanceStepExecutionListener
	) {
		stepBuilderFactory.get("importNeofinanceData").listener(neofinanceStepExecutionListener)
			.<NeofinanceTransactionDto, TransactionEntity> chunk(10)
			.reader(neofinanceItemReader)
			.processor(neofinanceItemProcessor)
			.writer(neofinanceItemWriter)
			.build()
	}
	
	@Bean
	StepExecutionListener neofinanceStepExecutionListener() {
		new NeofinanceStepExecutionListener()
	}
}
