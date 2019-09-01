package net.hemisoft.p2p.importer.plattform.peerberry

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobExecutionListener
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
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
	final JobBuilderFactory  jobBuilderFactory
	final StepBuilderFactory stepBuilderFactory

	PeerberryConfiguration(JobBuilderFactory  jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource peerberryResource(@Value('${path.peerberry.input}') def path) {
		new FileSystemResource(path)
	}

	// Reader, Processor and Writer ...
	
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
	
	// Job steps
	
	@Bean
	Job peerberryImportJob(JobExecutionListener peerberryJobCompletionNotificationListener, Step importPeerberryDataStep) {
		jobBuilderFactory.get("peerberryImportJob")
			.incrementer(RunIdIncrementer.newInstance())
			.listener(peerberryJobCompletionNotificationListener)
			.flow(importPeerberryDataStep)
			.end()
			.build()
	}
	
	@Bean
	Step importPeerberryDataStep(ItemReader peerberryItemReader, ItemProcessor peerberryItemProcessor, ItemWriter peerberryItemWriter) {
		stepBuilderFactory.get("step1")
			.<PeerberryTransactionDto, TransactionEntity> chunk(10)
			.reader(peerberryItemReader)
			.processor(peerberryItemProcessor)
			.writer(peerberryItemWriter)
			.build()
	}
	
	@Bean
	JobExecutionListener peerberryJobCompletionNotificationListener() {
		PeerberryJobCompletionNotificationListener.newInstance()
	}
}
