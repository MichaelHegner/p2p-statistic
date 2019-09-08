package net.hemisoft.p2p.converter.plattform.bondora

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
import net.hemisoft.p2p.converter.plattform.bondora.dto.BondoraLoanDto

@Configuration
@EnableBatchProcessing
public class BondoraConfiguration {
	@Autowired StepBuilderFactory stepBuilderFactory
	@Autowired JobBuilderFactory  jobBuilderFactory
	
	@Bean
	Resource bondoraResource(@Value('${path.bondora.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	Job bondoraImportJob(
		JobExecutionListener bondoraJobExecutionListener,
		Step importBondoraAccountDataStep,
		Step importBondoraLoanDataStep
	) {
		jobBuilderFactory.get("importBondoraDataJob").incrementer(RunIdIncrementer.newInstance())
			.listener(bondoraJobExecutionListener)
			.start(importBondoraAccountDataStep)
			.next(importBondoraLoanDataStep)
			.build()
	}
	
	@Bean
	Step importBondoraAccountDataStep(
		ItemReader bondoraAccountItemReader,
		ItemProcessor bondoraAccountItemProcessor,
		ItemWriter bondoraAccountItemWriter,
		StepExecutionListener bondoraAccountStepExecutionListener
	) {
		stepBuilderFactory.get("importBondoraAccountData").listener(bondoraAccountStepExecutionListener)
			.<BondoraLoanDto, TransactionEntity> chunk(10)
			.reader(bondoraAccountItemReader)
			.processor(bondoraAccountItemProcessor)
			.writer(bondoraAccountItemWriter)
			.build()
	}

	@Bean
	Step importBondoraLoanDataStep(
		ItemReader bondoraLoanItemReader, 
		ItemProcessor bondoraLoanItemProcessor, 
		ItemWriter bondoraLoanItemWriter,
		StepExecutionListener bondoraLoanStepExecutionListener
	) {
		stepBuilderFactory.get("importBondoraAccountData").listener(bondoraLoanStepExecutionListener)
			.<BondoraLoanDto, TransactionEntity> chunk(10)
			.reader(bondoraLoanItemReader)
			.processor(bondoraLoanItemProcessor)
			.writer(bondoraLoanItemWriter)
			.build()
	}
}
