package net.hemisoft.p2p.importer.plattform.crowdestate

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
public class CrowdestateConfiguration {
	final JobBuilderFactory  jobBuilderFactory
	final StepBuilderFactory stepBuilderFactory

	CrowdestateConfiguration(JobBuilderFactory  jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory
		this.stepBuilderFactory = stepBuilderFactory
	}
	
	@Bean
	Resource crowdestateResource(@Value('${path.crowdestate.input}') def path) {
		new FileSystemResource(path)
	}

	// Reader, Processor and Writer ...
	
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
	
	// Job steps
	
	@Bean
	Job crowdestateImportJob(JobExecutionListener crowdestateJobCompletionNotificationListener, Step importCrowdestateDataStep) {
		jobBuilderFactory.get("crowdestateImportJob")
			.incrementer(RunIdIncrementer.newInstance())
			.listener(crowdestateJobCompletionNotificationListener)
			.flow(importCrowdestateDataStep)
			.end()
			.build()
	}
	
	@Bean
	Step importCrowdestateDataStep(ItemReader crowdestateItemReader, ItemProcessor crowdestateItemProcessor, ItemWriter crowdestateItemWriter) {
		stepBuilderFactory.get("step1")
			.<CrowdestateTransactionDto, TransactionEntity> chunk(10)
			.reader(crowdestateItemReader)
			.processor(crowdestateItemProcessor)
			.writer(crowdestateItemWriter)
			.build()
	}
	
	@Bean
	JobExecutionListener crowdestateJobCompletionNotificationListener() {
		CrowdestateJobCompletionNotificationListener.newInstance()
	}
}
