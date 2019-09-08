package net.hemisoft.p2p.importer.plattform.iuvo

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
import net.hemisoft.p2p.importer.plattform.iuvo.dto.IuvoLoanDto

@Configuration
@EnableBatchProcessing
public class IuvoConfiguration {
	@Autowired StepBuilderFactory stepBuilderFactory
	@Autowired JobBuilderFactory  jobBuilderFactory
	
	@Bean
	Resource iuvoResource(@Value('${path.iuvo.input}') def path) {
		new FileSystemResource(path)
	}
	
	@Bean
	Job iuvoImportJob(
		JobExecutionListener iuvoJobExecutionListener,
		Step importIuvoAccountDataStep,
		Step importIuvoLoanDataStep
	) {
		jobBuilderFactory.get("importIuvoDataJob").incrementer(RunIdIncrementer.newInstance())
			.listener(iuvoJobExecutionListener)
			.start(importIuvoAccountDataStep)
			.next(importIuvoLoanDataStep)
			.build()
	}
	
	@Bean
	Step importIuvoAccountDataStep(
		ItemReader iuvoAccountItemReader,
		ItemProcessor iuvoAccountItemProcessor,
		ItemWriter iuvoAccountItemWriter,
		StepExecutionListener iuvoAccountStepExecutionListener
	) {
		stepBuilderFactory.get("importIuvoAccountData").listener(iuvoAccountStepExecutionListener)
			.<IuvoLoanDto, TransactionEntity> chunk(10)
			.reader(iuvoAccountItemReader)
			.processor(iuvoAccountItemProcessor)
			.writer(iuvoAccountItemWriter)
			.build()
	}

	@Bean
	Step importIuvoLoanDataStep(
		ItemReader iuvoLoanItemReader,
		ItemProcessor iuvoLoanItemProcessor,
		ItemWriter iuvoLoanItemWriter,
		StepExecutionListener iuvoLoanStepExecutionListener
	) {
		stepBuilderFactory.get("importIuvoLoanData").listener(iuvoLoanStepExecutionListener)
			.<IuvoLoanDto, TransactionEntity> chunk(10)
			.reader(iuvoLoanItemReader)
			.processor(iuvoLoanItemProcessor)
			.writer(iuvoLoanItemWriter)
			.build()
	}
}
