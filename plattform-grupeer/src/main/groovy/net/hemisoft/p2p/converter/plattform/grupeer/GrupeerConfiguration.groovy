package net.hemisoft.p2p.converter.plattform.grupeer

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
import net.hemisoft.p2p.converter.plattform.grupeer.dto.GrupeerLoanDto

@Configuration
@EnableBatchProcessing
public class GrupeerConfiguration {
	@Autowired StepBuilderFactory stepBuilderFactory
	@Autowired JobBuilderFactory  jobBuilderFactory
	
	
	@Bean
	Resource grupeerResource(@Value('${path.grupeer.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	Job grupeerImportJob(
		JobExecutionListener grupeerJobExecutionListener,
		Step importGrupeerAccountDataStep,
		Step importGrupeerLoanDataStep
	) {
		jobBuilderFactory.get("importGrupeerDataJob").incrementer(RunIdIncrementer.newInstance())
			.listener(grupeerJobExecutionListener)
			.start(importGrupeerAccountDataStep)
			.next(importGrupeerLoanDataStep)
			.build()
	}
	
	@Bean
	Step importGrupeerAccountDataStep(
		ItemReader grupeerAccountItemReader,
		ItemProcessor grupeerAccountItemProcessor,
		ItemWriter grupeerAccountItemWriter,
		StepExecutionListener grupeerAccountStepExecutionListener
	) {
		stepBuilderFactory.get("importGrupeerAccountData").listener(grupeerAccountStepExecutionListener)
			.<GrupeerLoanDto, TransactionEntity> chunk(10)
			.reader(grupeerAccountItemReader)
			.processor(grupeerAccountItemProcessor)
			.writer(grupeerAccountItemWriter)
			.build()
	}

	@Bean
	Step importGrupeerLoanDataStep(
		ItemReader grupeerLoanItemReader, 
		ItemProcessor grupeerLoanItemProcessor, 
		ItemWriter grupeerLoanItemWriter,
		StepExecutionListener grupeerLoanStepExecutionListener
	) {
		stepBuilderFactory.get("importGrupeerData").listener(grupeerLoanStepExecutionListener)
			.<GrupeerLoanDto, TransactionEntity> chunk(10)
			.reader(grupeerLoanItemReader)
			.processor(grupeerLoanItemProcessor)
			.writer(grupeerLoanItemWriter)
			.build()
	}
}
