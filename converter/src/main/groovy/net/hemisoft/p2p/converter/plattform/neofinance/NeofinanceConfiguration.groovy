package net.hemisoft.p2p.converter.plattform.neofinance

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

import net.hemisoft.p2p.converter.domain.TransactionEntity
import net.hemisoft.p2p.converter.plattform.neofinance.dto.NeofinanceAccountDto

@Configuration
@EnableBatchProcessing
public class NeofinanceConfiguration {
	@Autowired StepBuilderFactory stepBuilderFactory
	@Autowired JobBuilderFactory  jobBuilderFactory
	
	@Bean
	Resource neofinanceAccountResource(@Value('${path.neofinance.account.input}') def path) {
		new FileSystemResource(path)
	}
	
	@Bean
	Resource neofinanceLoanResource(@Value('${path.neofinance.loan.input}') def path) {
		new FileSystemResource(path)
	}
	
	
	@Bean
	Job neofinanceImportJob(
		JobExecutionListener neofinanceJobExecutionListener,
		Step importNeofinanceAccountDataStep,
		Step importNeofinanceLoanDataStep
	) {
		jobBuilderFactory.get("importNeofinanceDataJob").incrementer(RunIdIncrementer.newInstance())
			.listener(neofinanceJobExecutionListener)
			.start(importNeofinanceAccountDataStep)
			.next(importNeofinanceLoanDataStep)
			.build()
	}
	
	@Bean
	Step importNeofinanceAccountDataStep(
		ItemReader neofinanceAccountItemReader,
		ItemProcessor neofinanceAccountItemProcessor,
		ItemWriter neofinanceAccountItemWriter,
		StepExecutionListener neofinanceAccountStepExecutionListener
	) {
		stepBuilderFactory.get("importNeofinanceAccountData").listener(neofinanceAccountStepExecutionListener)
			.<NeofinanceAccountDto, TransactionEntity> chunk(10)
			.reader(neofinanceAccountItemReader)
			.processor(neofinanceAccountItemProcessor)
			.writer(neofinanceAccountItemWriter)
			.build()
	}

	@Bean
	Step importNeofinanceLoanDataStep(
		ItemReader neofinanceLoanItemReader, 
		ItemProcessor neofinanceLoanItemProcessor, 
		ItemWriter neofinanceLoanItemWriter,
		StepExecutionListener neofinanceLoanStepExecutionListener
	) {
		stepBuilderFactory.get("importNeofinanceLoanData").listener(neofinanceLoanStepExecutionListener)
			.<NeofinanceAccountDto, TransactionEntity> chunk(10)
			.reader(neofinanceLoanItemReader)
			.processor(neofinanceLoanItemProcessor)
			.writer(neofinanceLoanItemWriter)
			.build()
	}
}
