package net.hemisoft.p2p.converter.plattform.crowdestate

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
import net.hemisoft.p2p.converter.plattform.crowdestate.dto.CrowdestateLoanDto

@Configuration
@EnableBatchProcessing
public class CrowdestateConfiguration {
	@Autowired StepBuilderFactory stepBuilderFactory
	@Autowired JobBuilderFactory  jobBuilderFactory
	
	@Bean
	Resource crowdestateResource(@Value('${path.crowdestate.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	Job crowdestateImportJob(
		JobExecutionListener crowdestateJobExecutionListener,
		Step importCrowdestateAccountDataStep,
		Step importCrowdestateLoanDataStep
	) {
		jobBuilderFactory.get("importCrowdestateDataJob").incrementer(RunIdIncrementer.newInstance())
			.listener(crowdestateJobExecutionListener)
			.start(importCrowdestateAccountDataStep)
			.next(importCrowdestateLoanDataStep)
			.build()
	}
	
	@Bean
	Step importCrowdestateAccountDataStep(
		ItemReader crowdestateAccountItemReader,
		ItemProcessor crowdestateAccountItemProcessor,
		ItemWriter crowdestateAccountItemWriter,
		StepExecutionListener crowdestateAccountStepExecutionListener
	) {
		stepBuilderFactory.get("importCrowdestateAccountData").listener(crowdestateAccountStepExecutionListener)
			.<CrowdestateLoanDto, TransactionEntity> chunk(10)
			.reader(crowdestateAccountItemReader)
			.processor(crowdestateAccountItemProcessor)
			.writer(crowdestateAccountItemWriter)
			.build()
	}

	@Bean
	Step importCrowdestateLoanDataStep(
		ItemReader crowdestateLoanItemReader, 
		ItemProcessor crowdestateLoanItemProcessor, 
		ItemWriter crowdestateLoanItemWriter,
		StepExecutionListener crowdestateLoanStepExecutionListener
	) {
		stepBuilderFactory.get("importCrowdestateAccountData").listener(crowdestateLoanStepExecutionListener)
			.<CrowdestateLoanDto, TransactionEntity> chunk(10)
			.reader(crowdestateLoanItemReader)
			.processor(crowdestateLoanItemProcessor)
			.writer(crowdestateLoanItemWriter)
			.build()
	}
	
}
