package net.hemisoft.p2p.converter.plattform.flender

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobExecutionListener
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepExecutionListener
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.Resource

import net.hemisoft.p2p.converter.domain.entity.TransactionEntity
import net.hemisoft.p2p.converter.plattform.flender.dto.FlenderAccountDto

@Configuration
@EnableBatchProcessing
public class FlenderConfiguration {
	@Autowired StepBuilderFactory stepBuilderFactory
	@Autowired JobBuilderFactory  jobBuilderFactory

	
	@Bean
	Resource accountResource(@Value('${path.input.account}') def path) {
		new FileSystemResource(path)
	}
	
	@Bean
	Resource loanResource(@Value('${path.input.loan}') def path) {
		new FileSystemResource(path)
	}

	
	
	@Bean
	Job flenderImportJob(
		JobExecutionListener flenderJobExecutionListener,
		Step importFlenderAccountDataStep,
		Step importFlenderLoanDataStep
	) {
		jobBuilderFactory.get("importFlenderDataJob").incrementer(RunIdIncrementer.newInstance())
			.listener(flenderJobExecutionListener)
			.start(importFlenderAccountDataStep)
			.next(importFlenderLoanDataStep)
			.build()
	}
	
	@Bean
	Step importFlenderAccountDataStep(
		ItemReader flenderAccountItemReader,
		ItemProcessor flenderAccountItemProcessor,
		ItemWriter flenderAccountItemWriter,
		StepExecutionListener flenderAccountStepExecutionListener
	) {
		stepBuilderFactory.get("importFlenderAccountData").listener(flenderAccountStepExecutionListener)
			.<FlenderAccountDto, TransactionEntity> chunk(10)
			.reader(flenderAccountItemReader)
			.processor(flenderAccountItemProcessor)
			.writer(flenderAccountItemWriter)
			.build()
	}

	@Bean
	Step importFlenderLoanDataStep(
		ItemReader flenderLoanItemReader, 
		ItemProcessor flenderLoanItemProcessor, 
		ItemWriter flenderLoanItemWriter,
		StepExecutionListener flenderLoanStepExecutionListener
	) {
		stepBuilderFactory.get("importFlenderLoanData").listener(flenderLoanStepExecutionListener)
			.<FlenderAccountDto, TransactionEntity> chunk(10)
			.reader(flenderLoanItemReader)
			.processor(flenderLoanItemProcessor)
			.writer(flenderLoanItemWriter)
			.build()
	}
}
