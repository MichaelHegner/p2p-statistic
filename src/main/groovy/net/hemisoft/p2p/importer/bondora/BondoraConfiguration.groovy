package net.hemisoft.p2p.importer.bondora

import org.springframework.batch.core.Step
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
public class BondoraConfiguration {
	private final StepBuilderFactory stepBuilderFactory
	
	BondoraConfiguration(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource bondoraResource(@Value('${path.bondora.input}') def path) {
		new FileSystemResource(path)
	}

	
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
	
	
	@Bean
	Step importBondoraDataStep(ItemReader bondoraItemReader, ItemProcessor bondoraItemProcessor, ItemWriter bondoraItemWriter) {
		stepBuilderFactory.get("importBondoraData")
			.<BondoraTransactionDto, TransactionEntity> chunk(10)
			.reader(bondoraItemReader)
			.processor(bondoraItemProcessor)
			.writer(bondoraItemWriter)
			.build()
	}
}
