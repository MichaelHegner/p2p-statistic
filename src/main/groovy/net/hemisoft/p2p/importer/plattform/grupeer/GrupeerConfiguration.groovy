package net.hemisoft.p2p.importer.plattform.grupeer

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
public class GrupeerConfiguration {
	private final StepBuilderFactory stepBuilderFactory
	
	GrupeerConfiguration(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource grupeerResource(@Value('${path.grupeer.input}') def path) {
		new FileSystemResource(path)
	}

	
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
	
	
	@Bean
	Step importGrupeerDataStep(
		ItemReader grupeerItemReader, 
		ItemProcessor grupeerItemProcessor, 
		ItemWriter grupeerItemWriter,
		StepExecutionListener grupeerStepExecutionListener
	) {
		stepBuilderFactory.get("importGrupeerData").listener(grupeerStepExecutionListener)
			.<GrupeerTransactionDto, TransactionEntity> chunk(10)
			.reader(grupeerItemReader)
			.processor(grupeerItemProcessor)
			.writer(grupeerItemWriter)
			.build()
	}
	
	@Bean
	StepExecutionListener grupeerStepExecutionListener() {
		new GrupeerStepExecutionListener()
	}
}
