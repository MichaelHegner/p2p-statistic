package net.hemisoft.p2p.converter.converter.plattform.viventor

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

import net.hemisoft.p2p.converter.converter.plattform.viventor.dto.ViventorLoanDto
import net.hemisoft.p2p.converter.domain.entity.TransactionEntity

@Configuration
@EnableBatchProcessing
public class ViventorConfiguration {
	@Autowired StepBuilderFactory stepBuilderFactory
	@Autowired JobBuilderFactory  jobBuilderFactory
	
	@Bean
	Resource viventorResource(@Value('${path.viventor.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	Job viventorImportJob(
		JobExecutionListener viventorJobExecutionListener,
		Step importViventorAccountDataStep,
		Step importViventorLoanDataStep
	) {
		jobBuilderFactory.get("importViventorDataJob").incrementer(RunIdIncrementer.newInstance())
			.listener(viventorJobExecutionListener)
			.start(importViventorAccountDataStep)
			.next(importViventorLoanDataStep)
			.build()
	}
	
	@Bean
	Step importViventorAccountDataStep(
		ItemReader viventorAccountItemReader,
		ItemProcessor viventorAccountItemProcessor,
		ItemWriter viventorAccountItemWriter,
		StepExecutionListener viventorAccountStepExecutionListener
	) {
		stepBuilderFactory.get("importViventorAccountData").listener(viventorAccountStepExecutionListener)
			.<ViventorLoanDto, TransactionEntity> chunk(10)
			.reader(viventorAccountItemReader)
			.processor(viventorAccountItemProcessor)
			.writer(viventorAccountItemWriter)
			.build()
	}

	@Bean
	Step importViventorLoanDataStep(
		ItemReader viventorLoanItemReader,
		ItemProcessor viventorLoanItemProcessor,
		ItemWriter viventorLoanItemWriter,
		StepExecutionListener viventorLoanStepExecutionListener
	) {
		stepBuilderFactory.get("importViventorLoanData").listener(viventorLoanStepExecutionListener)
			.<ViventorLoanDto, TransactionEntity> chunk(10)
			.reader(viventorLoanItemReader)
			.processor(viventorLoanItemProcessor)
			.writer(viventorLoanItemWriter)
			.build()
	}
}
