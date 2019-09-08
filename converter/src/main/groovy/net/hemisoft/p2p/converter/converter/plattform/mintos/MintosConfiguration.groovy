package net.hemisoft.p2p.converter.converter.plattform.mintos

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

import net.hemisoft.p2p.converter.converter.plattform.mintos.dto.MintosLoanDto
import net.hemisoft.p2p.converter.domain.entity.TransactionEntity

@Configuration
@EnableBatchProcessing
public class MintosConfiguration {
	@Autowired StepBuilderFactory stepBuilderFactory
	@Autowired JobBuilderFactory  jobBuilderFactory
	
	@Bean
	Resource mintosResource(@Value('${path.mintos.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	Job mintosImportJob(
		JobExecutionListener mintosJobExecutionListener,
		Step importMintosAccountDataStep,
		Step importMintosLoanDataStep
	) {
		jobBuilderFactory.get("importMintosDataJob").incrementer(RunIdIncrementer.newInstance())
			.listener(mintosJobExecutionListener)
			.start(importMintosAccountDataStep)
			.next(importMintosLoanDataStep)
			.build()
	}
	
	@Bean
	Step importMintosAccountDataStep(
		ItemReader mintosAccountItemReader,
		ItemProcessor mintosAccountItemProcessor,
		ItemWriter mintosAccountItemWriter,
		StepExecutionListener mintosAccountStepExecutionListener
	) {
		stepBuilderFactory.get("importMintosAccountData").listener(mintosAccountStepExecutionListener)
			.<MintosLoanDto, TransactionEntity> chunk(10)
			.reader(mintosAccountItemReader)
			.processor(mintosAccountItemProcessor)
			.writer(mintosAccountItemWriter)
			.build()
	}

	@Bean
	Step importMintosLoanDataStep(
		ItemReader mintosLoanItemReader,
		ItemProcessor mintosLoanItemProcessor,
		ItemWriter mintosLoanItemWriter,
		StepExecutionListener mintosLoanStepExecutionListener
	) {
		stepBuilderFactory.get("importMintosLoanData").listener(mintosLoanStepExecutionListener)
			.<MintosLoanDto, TransactionEntity> chunk(10)
			.reader(mintosLoanItemReader)
			.processor(mintosLoanItemProcessor)
			.writer(mintosLoanItemWriter)
			.build()
	}
}
