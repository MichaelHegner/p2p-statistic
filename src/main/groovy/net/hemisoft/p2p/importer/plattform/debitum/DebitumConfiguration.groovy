package net.hemisoft.p2p.importer.plattform.debitum

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
public class DebitumConfiguration {
	private final StepBuilderFactory stepBuilderFactory
	
	DebitumConfiguration(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource debitumResource(@Value('${path.debitum.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	ItemReader debitumItemReader(Resource debitumResource) {
		DebitumItemReader.newInstance debitumResource
	}

	@Bean
	ItemProcessor debitumItemProcessor() {
		new DebitumItemProcessor()
	}
	
	@Bean
	ItemWriter debitumItemWriter() {
		new DebitumItemWriter()
	}
	
	
	@Bean
	Step importDebitumDataStep(ItemReader debitumItemReader, ItemProcessor debitumItemProcessor, ItemWriter debitumItemWriter) {
		stepBuilderFactory.get("importDebitumData")
			.<DebitumTransactionDto, TransactionEntity> chunk(10)
			.reader(debitumItemReader)
			.processor(debitumItemProcessor)
			.writer(debitumItemWriter)
			.build()
	}
}
