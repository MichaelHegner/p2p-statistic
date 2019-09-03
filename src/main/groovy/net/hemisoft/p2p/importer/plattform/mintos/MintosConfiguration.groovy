package net.hemisoft.p2p.importer.plattform.mintos

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
public class MintosConfiguration {
	private final StepBuilderFactory stepBuilderFactory
	
	MintosConfiguration(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource mintosResource(@Value('${path.mintos.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	ItemReader mintosItemReader(Resource mintosResource) {
		MintosItemReader.newInstance mintosResource
	}

	@Bean
	ItemProcessor mintosItemProcessor() {
		new MintosItemProcessor()
	}
	
	@Bean
	ItemWriter mintosItemWriter() {
		new MintosItemWriter()
	}
	
	
	@Bean
	Step importMintosDataStep(ItemReader mintosItemReader, ItemProcessor mintosItemProcessor, ItemWriter mintosItemWriter) {
		stepBuilderFactory.get("importMintosData")
			.<MintosTransactionDto, TransactionEntity> chunk(10)
			.reader(mintosItemReader)
			.processor(mintosItemProcessor)
			.writer(mintosItemWriter)
			.build()
	}
}
