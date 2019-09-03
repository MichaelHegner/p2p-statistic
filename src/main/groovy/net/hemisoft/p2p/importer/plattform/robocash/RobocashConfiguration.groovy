package net.hemisoft.p2p.importer.plattform.robocash

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
public class RobocashConfiguration {
	private final StepBuilderFactory stepBuilderFactory
	
	RobocashConfiguration(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource robocashResource(@Value('${path.robocash.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	ItemReader robocashItemReader(Resource robocashResource) {
		RobocashItemReader.newInstance robocashResource
	}

	@Bean
	ItemProcessor robocashItemProcessor() {
		new RobocashItemProcessor()
	}
	
	@Bean
	ItemWriter robocashItemWriter() {
		new RobocashItemWriter()
	}
	
	
	@Bean
	Step importRobocashDataStep(ItemReader robocashItemReader, ItemProcessor robocashItemProcessor, ItemWriter robocashItemWriter) {
		stepBuilderFactory.get("importRobocashData")
			.<RobocashTransactionDto, TransactionEntity> chunk(10)
			.reader(robocashItemReader)
			.processor(robocashItemProcessor)
			.writer(robocashItemWriter)
			.build()
	}
}
