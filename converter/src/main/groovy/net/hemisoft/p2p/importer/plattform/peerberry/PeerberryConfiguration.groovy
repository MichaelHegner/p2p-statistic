package net.hemisoft.p2p.importer.plattform.peerberry

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
import net.hemisoft.p2p.importer.plattform.peerberry.dto.PeerberryAccountDto

@Configuration
@EnableBatchProcessing
public class PeerberryConfiguration {
	@Autowired StepBuilderFactory stepBuilderFactory
	@Autowired JobBuilderFactory  jobBuilderFactory
	
	@Bean
	Resource peerberryResource(@Value('${path.peerberry.input}') def path) {
		new FileSystemResource(path)
	}

	
	@Bean
	Job peerberryImportJob(
		JobExecutionListener peerberryJobExecutionListener,
		Step importPeerberryAccountDataStep,
		Step importPeerberryLoanDataStep
	) {
		jobBuilderFactory.get("importPeerberryDataJob").incrementer(RunIdIncrementer.newInstance())
			.listener(peerberryJobExecutionListener)
			.start(importPeerberryAccountDataStep)
			.next(importPeerberryLoanDataStep)
			.build()
	}
	
	@Bean
	Step importPeerberryAccountDataStep(
		ItemReader peerberryAccountItemReader,
		ItemProcessor peerberryAccountItemProcessor,
		ItemWriter peerberryAccountItemWriter,
		StepExecutionListener peerberryAccountStepExecutionListener
	) {
		stepBuilderFactory.get("importPeerberryAccountData").listener(peerberryAccountStepExecutionListener)
			.<PeerberryAccountDto, TransactionEntity> chunk(10)
			.reader(peerberryAccountItemReader)
			.processor(peerberryAccountItemProcessor)
			.writer(peerberryAccountItemWriter)
			.build()
	}

	@Bean
	Step importPeerberryLoanDataStep(
		ItemReader peerberryLoanItemReader, 
		ItemProcessor peerberryLoanItemProcessor, 
		ItemWriter peerberryLoanItemWriter,
		StepExecutionListener peerberryLoanStepExecutionListener
	) {
		stepBuilderFactory.get("importPeerberryLoanData").listener(peerberryLoanStepExecutionListener)
			.<PeerberryAccountDto, TransactionEntity> chunk(10)
			.reader(peerberryLoanItemReader)
			.processor(peerberryLoanItemProcessor)
			.writer(peerberryLoanItemWriter)
			.build()
	}
}
