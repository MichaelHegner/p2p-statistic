package net.hemisoft.p2p.importer.plattform.investly

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
public class InvestlyConfiguration {
	private final StepBuilderFactory stepBuilderFactory
	
	InvestlyConfiguration(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource investlyResource(@Value('${path.investly.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	ItemReader investlyItemReader(Resource investlyResource) {
		InvestlyItemReader.newInstance investlyResource
	}

	@Bean
	ItemProcessor investlyItemProcessor() {
		new InvestlyItemProcessor()
	}
	
	@Bean
	ItemWriter investlyItemWriter() {
		new InvestlyItemWriter()
	}
	
	
	@Bean
	Step importInvestlyDataStep(ItemReader investlyItemReader, ItemProcessor investlyItemProcessor, ItemWriter investlyItemWriter) {
		stepBuilderFactory.get("importInvestlyData")
			.<InvestlyTransactionDto, TransactionEntity> chunk(10)
			.reader(investlyItemReader)
			.processor(investlyItemProcessor)
			.writer(investlyItemWriter)
			.build()
	}
}
