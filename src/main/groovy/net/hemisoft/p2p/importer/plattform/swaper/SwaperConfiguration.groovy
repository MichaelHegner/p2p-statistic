package net.hemisoft.p2p.importer.plattform.swaper

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
public class SwaperConfiguration {
	private final StepBuilderFactory stepBuilderFactory
	
	SwaperConfiguration(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource swaperResource(@Value('${path.swaper.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	ItemReader swaperItemReader(Resource swaperResource) {
		SwaperItemReader.newInstance swaperResource
	}

	@Bean
	ItemProcessor swaperItemProcessor() {
		new SwaperItemProcessor()
	}
	
	@Bean
	ItemWriter swaperItemWriter() {
		new SwaperItemWriter()
	}
	
	
	@Bean
	Step importSwaperDataStep(
		ItemReader swaperItemReader, 
		ItemProcessor swaperItemProcessor, 
		ItemWriter swaperItemWriter,
		StepExecutionListener swaperStepExecutionListener
	) {
		stepBuilderFactory.get("importSwaperData").listener(swaperStepExecutionListener)
			.<SwaperTransactionDto, TransactionEntity> chunk(10)
			.reader(swaperItemReader)
			.processor(swaperItemProcessor)
			.writer(swaperItemWriter)
			.build()
	}
	
	@Bean
	StepExecutionListener swaperStepExecutionListener() {
		new SwaperStepExecutionListener()
	}
}
