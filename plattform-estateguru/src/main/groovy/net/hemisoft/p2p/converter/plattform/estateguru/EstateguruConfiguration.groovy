package net.hemisoft.p2p.converter.plattform.estateguru

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
import net.hemisoft.p2p.converter.plattform.estateguru.dto.EstateguruLoanDto

@Configuration
@EnableBatchProcessing
public class EstateguruConfiguration {
	@Autowired StepBuilderFactory stepBuilderFactory
	@Autowired JobBuilderFactory  jobBuilderFactory
	
	
	@Bean
	Resource estateguruResource(@Value('${path.input}') def path) {
		new FileSystemResource(path)
	}

	
	
	@Bean
	Job estateguruImportJob(
		JobExecutionListener estateguruJobExecutionListener,
		Step importEstateguruAccountDataStep,
		Step importEstateguruLoanDataStep
	) {
		jobBuilderFactory.get("importEstateguruDataJob").incrementer(RunIdIncrementer.newInstance())
			.listener(estateguruJobExecutionListener)
			.start(importEstateguruAccountDataStep)
			.next(importEstateguruLoanDataStep)
			.build()
	}
	
	@Bean
	Step importEstateguruAccountDataStep(
		ItemReader estateguruAccountItemReader,
		ItemProcessor estateguruAccountItemProcessor,
		ItemWriter estateguruAccountItemWriter,
		StepExecutionListener estateguruAccountStepExecutionListener
	) {
		stepBuilderFactory.get("importEstateguruData").listener(estateguruAccountStepExecutionListener)
			.<EstateguruLoanDto, TransactionEntity> chunk(10)
			.reader(estateguruAccountItemReader)
			.processor(estateguruAccountItemProcessor)
			.writer(estateguruAccountItemWriter)
			.build()
	}

	@Bean
	Step importEstateguruLoanDataStep(
		ItemReader estateguruLoanItemReader, 
		ItemProcessor estateguruLoanItemProcessor, 
		ItemWriter estateguruLoanItemWriter,
		StepExecutionListener estateguruLoanStepExecutionListener
	) {
		stepBuilderFactory.get("importEstateguruData").listener(estateguruLoanStepExecutionListener)
			.<EstateguruLoanDto, TransactionEntity> chunk(10)
			.reader(estateguruLoanItemReader)
			.processor(estateguruLoanItemProcessor)
			.writer(estateguruLoanItemWriter)
			.build()
	}
}
