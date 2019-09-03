package net.hemisoft.p2p.importer.plattform.estateguru

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
public class EstateguruConfiguration {
	private final StepBuilderFactory stepBuilderFactory
	
	EstateguruConfiguration(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource estateguruResource(@Value('${path.estateguru.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	ItemReader estateguruItemReader(Resource estateguruResource) {
		EstateguruItemReader.newInstance estateguruResource
	}

	@Bean
	ItemProcessor estateguruItemProcessor() {
		new EstateguruItemProcessor()
	}
	
	@Bean
	ItemWriter estateguruItemWriter() {
		new EstateguruItemWriter()
	}
	
	
	@Bean
	Step importEstateguruDataStep(ItemReader estateguruItemReader, ItemProcessor estateguruItemProcessor, ItemWriter estateguruItemWriter) {
		stepBuilderFactory.get("importEstateguruData")
			.<EstateguruTransactionDto, TransactionEntity> chunk(10)
			.reader(estateguruItemReader)
			.processor(estateguruItemProcessor)
			.writer(estateguruItemWriter)
			.build()
	}
}
