package net.hemisoft.p2p.importer.plattform.debitum

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

import net.hemisoft.p2p.importer.domain.TransactionEntity
import net.hemisoft.p2p.importer.plattform.debitum.dto.DebitumLoanDto
import net.hemisoft.p2p.importer.plattform.debitum.listener.DebitumAccountStepExecutionListener
import net.hemisoft.p2p.importer.plattform.debitum.listener.DebitumJobExecutionListener
import net.hemisoft.p2p.importer.plattform.debitum.listener.DebitumLoanStepExecutionListener
import net.hemisoft.p2p.importer.plattform.debitum.processor.DebitumAccountItemProcessor
import net.hemisoft.p2p.importer.plattform.debitum.processor.DebitumLoanItemProcessor
import net.hemisoft.p2p.importer.plattform.debitum.reader.DebitumAccountItemReader
import net.hemisoft.p2p.importer.plattform.debitum.reader.DebitumLoanItemReader
import net.hemisoft.p2p.importer.plattform.debitum.writer.DebitumAccountItemWriter
import net.hemisoft.p2p.importer.plattform.debitum.writer.DebitumLoanItemWriter

@Configuration
@EnableBatchProcessing
public class DebitumConfiguration {
	@Autowired StepBuilderFactory stepBuilderFactory
	@Autowired JobBuilderFactory  jobBuilderFactory
	
	
	@Bean
	Resource debitumResource(@Value('${path.debitum.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	ItemReader debitumAccountItemReader(Resource debitumResource) {
		DebitumAccountItemReader.newInstance debitumResource
	}
	
	@Bean
	ItemReader debitumLoanItemReader(Resource debitumResource) {
		DebitumLoanItemReader.newInstance debitumResource
	}


	@Bean
	ItemProcessor debitumAccountItemProcessor() {
		new DebitumAccountItemProcessor()
	}
	
	@Bean
	ItemProcessor debitumLoanItemProcessor() {
		new DebitumLoanItemProcessor()
	}
	
	@Bean
	ItemWriter debitumAccountItemWriter() {
		new DebitumAccountItemWriter()
	}

	@Bean
	ItemWriter debitumLoanItemWriter() {
		new DebitumLoanItemWriter()
	}
	
	
	@Bean
	Job debitumImportJob(
		JobExecutionListener debitumJobExecutionListener,
		Step importDebitumAccountDataStep,
		Step importDebitumLoanDataStep
	) {
		jobBuilderFactory.get("importDebitumDataJob").incrementer(RunIdIncrementer.newInstance())
			.listener(debitumJobExecutionListener)
			.start(importDebitumAccountDataStep)
			.next(importDebitumLoanDataStep)
			.build()
	}
	
	@Bean
	Step importDebitumAccountDataStep(
		ItemReader debitumAccountItemReader,
		ItemProcessor debitumAccountItemProcessor,
		ItemWriter debitumAccountItemWriter,
		StepExecutionListener debitumAccountStepExecutionListener
	) {
		stepBuilderFactory.get("importDebitumAccountData").listener(debitumAccountStepExecutionListener)
			.<DebitumLoanDto, TransactionEntity> chunk(10)
			.reader(debitumAccountItemReader)
			.processor(debitumAccountItemProcessor)
			.writer(debitumAccountItemWriter)
			.build()
	}

	@Bean
	Step importDebitumLoanDataStep(
		ItemReader debitumLoanItemReader, 
		ItemProcessor debitumLoanItemProcessor, 
		ItemWriter debitumLoanItemWriter,
		StepExecutionListener debitumLoanStepExecutionListener
	) {
		stepBuilderFactory.get("importDebitumLoanData").listener(debitumLoanStepExecutionListener)
			.<DebitumLoanDto, TransactionEntity> chunk(10)
			.reader(debitumLoanItemReader)
			.processor(debitumLoanItemProcessor)
			.writer(debitumLoanItemWriter)
			.build()
	}
	
	
	@Bean
	StepExecutionListener debitumAccountStepExecutionListener() {
		new DebitumAccountStepExecutionListener()
	}

	@Bean
	StepExecutionListener debitumLoanStepExecutionListener() {
		new DebitumLoanStepExecutionListener()
	}
	
	@Bean
	JobExecutionListener debitumJobExecutionListener() {
		new DebitumJobExecutionListener()
	}
}
