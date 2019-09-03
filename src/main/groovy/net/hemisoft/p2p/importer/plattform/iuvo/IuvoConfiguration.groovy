package net.hemisoft.p2p.importer.plattform.iuvo

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
public class IuvoConfiguration {
	private final StepBuilderFactory stepBuilderFactory
	
	IuvoConfiguration(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource iuvoResource(@Value('${path.iuvo.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	ItemReader iuvoItemReader(Resource iuvoResource) {
		IuvoItemReader.newInstance iuvoResource
	}

	@Bean
	ItemProcessor iuvoItemProcessor() {
		new IuvoItemProcessor()
	}
	
	@Bean
	ItemWriter iuvoItemWriter() {
		new IuvoItemWriter()
	}
	
	
	@Bean
	Step importIuvoDataStep(ItemReader iuvoItemReader, ItemProcessor iuvoItemProcessor, ItemWriter iuvoItemWriter) {
		stepBuilderFactory.get("importIuvoData")
			.<IuvoTransactionDto, TransactionEntity> chunk(10)
			.reader(iuvoItemReader)
			.processor(iuvoItemProcessor)
			.writer(iuvoItemWriter)
			.build()
	}
}
