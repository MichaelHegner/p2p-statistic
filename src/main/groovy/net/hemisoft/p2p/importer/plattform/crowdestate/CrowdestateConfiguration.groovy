package net.hemisoft.p2p.importer.plattform.crowdestate

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
public class CrowdestateConfiguration {
	private final StepBuilderFactory stepBuilderFactory
	
	CrowdestateConfiguration(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource crowdestateResource(@Value('${path.crowdestate.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	ItemReader crowdestateItemReader(Resource crowdestateResource) {
		CrowdestateItemReader.newInstance crowdestateResource
	}

	@Bean
	ItemProcessor crowdestateItemProcessor() {
		new CrowdestateItemProcessor()
	}
	
	@Bean
	ItemWriter crowdestateItemWriter() {
		new CrowdestateItemWriter()
	}
	
	
	@Bean
	Step importCrowdestateDataStep(ItemReader crowdestateItemReader, ItemProcessor crowdestateItemProcessor, ItemWriter crowdestateItemWriter) {
		stepBuilderFactory.get("importCrowdestateData")
			.<CrowdestateTransactionDto, TransactionEntity> chunk(10)
			.reader(crowdestateItemReader)
			.processor(crowdestateItemProcessor)
			.writer(crowdestateItemWriter)
			.build()
	}
}
