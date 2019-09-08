package net.hemisoft.p2p.converter.plattform.twino

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
import net.hemisoft.p2p.converter.plattform.twino.dto.TwinoLoanDto

@Configuration
@EnableBatchProcessing
public class TwinoConfiguration {
	@Autowired StepBuilderFactory stepBuilderFactory
	@Autowired JobBuilderFactory  jobBuilderFactory
	
	@Bean
	Resource twinoResource(@Value('${path.twino.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	Job twinoImportJob(
		JobExecutionListener twinoJobExecutionListener,
		Step importTwinoAccountDataStep,
		Step importTwinoLoanDataStep
	) {
		jobBuilderFactory.get("importTwinoDataJob").incrementer(RunIdIncrementer.newInstance())
			.listener(twinoJobExecutionListener)
			.start(importTwinoAccountDataStep)
			.next(importTwinoLoanDataStep)
			.build()
	}
	
	@Bean
	Step importTwinoAccountDataStep(
		ItemReader twinoAccountItemReader,
		ItemProcessor twinoAccountItemProcessor,
		ItemWriter twinoAccountItemWriter,
		StepExecutionListener twinoAccountStepExecutionListener
	) {
		stepBuilderFactory.get("importTwinoAccountData").listener(twinoAccountStepExecutionListener)
			.<TwinoLoanDto, TransactionEntity> chunk(10)
			.reader(twinoAccountItemReader)
			.processor(twinoAccountItemProcessor)
			.writer(twinoAccountItemWriter)
			.build()
	}

	@Bean
	Step importTwinoLoanDataStep(
		ItemReader twinoLoanItemReader,
		ItemProcessor twinoLoanItemProcessor,
		ItemWriter twinoLoanItemWriter,
		StepExecutionListener twinoLoanStepExecutionListener
	) {
		stepBuilderFactory.get("importTwinoLoanData").listener(twinoLoanStepExecutionListener)
			.<TwinoLoanDto, TransactionEntity> chunk(10)
			.reader(twinoLoanItemReader)
			.processor(twinoLoanItemProcessor)
			.writer(twinoLoanItemWriter)
			.build()
	}
}
