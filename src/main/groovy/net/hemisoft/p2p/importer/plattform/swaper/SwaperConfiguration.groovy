package net.hemisoft.p2p.importer.plattform.swaper

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
import net.hemisoft.p2p.importer.plattform.swaper.dto.SwaperLoanDto

@Configuration
@EnableBatchProcessing
public class SwaperConfiguration {
	@Autowired StepBuilderFactory stepBuilderFactory
	@Autowired JobBuilderFactory  jobBuilderFactory
	
	@Bean
	Resource swaperResource(@Value('${path.swaper.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	Job swaperImportJob(
		JobExecutionListener swaperJobExecutionListener,
		Step importSwaperAccountDataStep,
		Step importSwaperLoanDataStep
	) {
		jobBuilderFactory.get("importSwaperDataJob").incrementer(RunIdIncrementer.newInstance())
			.listener(swaperJobExecutionListener)
			.start(importSwaperAccountDataStep)
			.next(importSwaperLoanDataStep)
			.build()
	}
	
	@Bean
	Step importSwaperAccountDataStep(
		ItemReader swaperAccountItemReader,
		ItemProcessor swaperAccountItemProcessor,
		ItemWriter swaperAccountItemWriter,
		StepExecutionListener swaperAccountStepExecutionListener
	) {
		stepBuilderFactory.get("importSwaperAccountData").listener(swaperAccountStepExecutionListener)
			.<SwaperLoanDto, TransactionEntity> chunk(10)
			.reader(swaperAccountItemReader)
			.processor(swaperAccountItemProcessor)
			.writer(swaperAccountItemWriter)
			.build()
	}

	@Bean
	Step importSwaperLoanDataStep(
		ItemReader swaperLoanItemReader,
		ItemProcessor swaperLoanItemProcessor,
		ItemWriter swaperLoanItemWriter,
		StepExecutionListener swaperLoanStepExecutionListener
	) {
		stepBuilderFactory.get("importSwaperLoanData").listener(swaperLoanStepExecutionListener)
			.<SwaperLoanDto, TransactionEntity> chunk(10)
			.reader(swaperLoanItemReader)
			.processor(swaperLoanItemProcessor)
			.writer(swaperLoanItemWriter)
			.build()
	}
}
