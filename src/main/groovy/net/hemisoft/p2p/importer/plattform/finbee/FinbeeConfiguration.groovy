package net.hemisoft.p2p.importer.plattform.finbee

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
import net.hemisoft.p2p.importer.plattform.finbee.dto.FinbeeLoanDto
import net.hemisoft.p2p.importer.plattform.finbee.processor.FinbeeAccountItemProcessor
import net.hemisoft.p2p.importer.plattform.finbee.processor.FinbeeLoanItemProcessor
import net.hemisoft.p2p.importer.plattform.finbee.reader.FinbeeAccountItemReader
import net.hemisoft.p2p.importer.plattform.finbee.reader.FinbeeLoanItemReader

@Configuration
@EnableBatchProcessing
public class FinbeeConfiguration {
	@Autowired StepBuilderFactory stepBuilderFactory
	@Autowired JobBuilderFactory  jobBuilderFactory
	
	
	@Bean
	Resource finbeeResource(@Value('${path.finbee.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	ItemReader finbeeAccountItemReader(Resource finbeeResource) {
		FinbeeAccountItemReader.newInstance finbeeResource
	}

	@Bean
	ItemReader finbeeLoanItemReader(Resource finbeeResource) {
		FinbeeLoanItemReader.newInstance finbeeResource
	}

		
	@Bean
	ItemProcessor finbeeAccountItemProcessor() {
		new FinbeeAccountItemProcessor()
	}

	@Bean
	ItemProcessor finbeeLoanItemProcessor() {
		new FinbeeLoanItemProcessor()
	}
	
	
	@Bean
	Job finbeeImportJob(
		JobExecutionListener finbeeJobExecutionListener,
		Step importFinbeeAccountDataStep,
		Step importFinbeeLoanDataStep
	) {
		jobBuilderFactory.get("importFinbeeDataJob").incrementer(RunIdIncrementer.newInstance())
			.listener(finbeeJobExecutionListener)
			.start(importFinbeeAccountDataStep)
			.next(importFinbeeLoanDataStep)
			.build()
	}
	
	@Bean
	Step importFinbeeAccountDataStep(
		ItemReader finbeeAccountItemReader,
		ItemProcessor finbeeAccountItemProcessor,
		ItemWriter finbeeAccountItemWriter,
		StepExecutionListener finbeeAccountStepExecutionListener
	) {
		stepBuilderFactory.get("importFinbeeAccountData").listener(finbeeAccountStepExecutionListener)
			.<FinbeeLoanDto, TransactionEntity> chunk(10)
			.reader(finbeeAccountItemReader)
			.processor(finbeeAccountItemProcessor)
			.writer(finbeeAccountItemWriter)
			.build()
	}
	
	@Bean
	Step importFinbeeLoanDataStep(
		ItemReader finbeeLoanItemReader, 
		ItemProcessor finbeeLoanItemProcessor, 
		ItemWriter finbeeLoanItemWriter,
		StepExecutionListener finbeeLoanStepExecutionListener
	) {
		stepBuilderFactory.get("importFinbeeLoanData").listener(finbeeLoanStepExecutionListener)
			.<FinbeeLoanDto, TransactionEntity> chunk(10)
			.reader(finbeeLoanItemReader)
			.processor(finbeeLoanItemProcessor)
			.writer(finbeeLoanItemWriter)
			.build()
	}
}
