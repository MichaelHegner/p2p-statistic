package net.hemisoft.p2p.converter.plattform.robocash

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
import net.hemisoft.p2p.converter.plattform.robocash.dto.RobocashLoanDto

@Configuration
@EnableBatchProcessing
public class RobocashConfiguration {
	@Autowired StepBuilderFactory stepBuilderFactory
	@Autowired JobBuilderFactory  jobBuilderFactory
	
	@Bean
	Resource robocashResource(@Value('${path.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	Job robocashImportJob(
		JobExecutionListener robocashJobExecutionListener,
		Step importRobocashAccountDataStep,
		Step importRobocashLoanDataStep
	) {
		jobBuilderFactory.get("importRobocashDataJob").incrementer(RunIdIncrementer.newInstance())
			.listener(robocashJobExecutionListener)
			.start(importRobocashAccountDataStep)
			.next(importRobocashLoanDataStep)
			.build()
	}
	
	@Bean
	Step importRobocashAccountDataStep(
		ItemReader robocashAccountItemReader,
		ItemProcessor robocashAccountItemProcessor,
		ItemWriter robocashAccountItemWriter,
		StepExecutionListener robocashAccountStepExecutionListener
	) {
		stepBuilderFactory.get("importRobocashAccountData").listener(robocashAccountStepExecutionListener)
			.<RobocashLoanDto, TransactionEntity> chunk(10)
			.reader(robocashAccountItemReader)
			.processor(robocashAccountItemProcessor)
			.writer(robocashAccountItemWriter)
			.build()
	}

	@Bean
	Step importRobocashLoanDataStep(
		ItemReader robocashLoanItemReader,
		ItemProcessor robocashLoanItemProcessor,
		ItemWriter robocashLoanItemWriter,
		StepExecutionListener robocashLoanStepExecutionListener
	) {
		stepBuilderFactory.get("importRobocashLoanData").listener(robocashLoanStepExecutionListener)
			.<RobocashLoanDto, TransactionEntity> chunk(10)
			.reader(robocashLoanItemReader)
			.processor(robocashLoanItemProcessor)
			.writer(robocashLoanItemWriter)
			.build()
	}
}
