package net.hemisoft.p2p.importer.plattform.peerberry

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
public class PeerberryConfiguration {
	private final StepBuilderFactory stepBuilderFactory
	
	PeerberryConfiguration(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource peerberryResource(@Value('${path.peerberry.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	ItemReader peerberryItemReader(Resource peerberryResource) {
		PeerberryItemReader.newInstance peerberryResource
	}

	@Bean
	ItemProcessor peerberryItemProcessor() {
		new PeerberryItemProcessor()
	}
	
	@Bean
	ItemWriter peerberryItemWriter() {
		new PeerberryItemWriter()
	}
	
	
	@Bean
	Step importPeerberryDataStep(ItemReader peerberryItemReader, ItemProcessor peerberryItemProcessor, ItemWriter peerberryItemWriter) {
		stepBuilderFactory.get("importPeerberryData")
			.<PeerberryTransactionDto, TransactionEntity> chunk(10)
			.reader(peerberryItemReader)
			.processor(peerberryItemProcessor)
			.writer(peerberryItemWriter)
			.build()
	}
}
