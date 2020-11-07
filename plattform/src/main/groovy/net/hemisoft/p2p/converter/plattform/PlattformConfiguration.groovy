package net.hemisoft.p2p.converter.plattform

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
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Loan
import net.hemisoft.p2p.converter.plattform.dto.AccountDto
import net.hemisoft.p2p.converter.plattform.dto.LoanDto

@Configuration
@EnableBatchProcessing
public class PlattformConfiguration {
    @Autowired StepBuilderFactory stepBuilderFactory
    @Autowired JobBuilderFactory  jobBuilderFactory
    
    
    @Bean
    Job importJob(
        JobExecutionListener jobExecutionListener,
        Step importAccountDataStep,
        Step importLoanDataStep
    ) {
        jobBuilderFactory.get("converterJob").incrementer(RunIdIncrementer.newInstance())
            .listener(jobExecutionListener)
            .start(importAccountDataStep)
            .next(importLoanDataStep)
            .build()
    }
    
    @Bean
    Step importAccountDataStep(
        ItemReader plattformAccountItemReader,
        ItemProcessor plattformAccountItemProcessor,
        ItemWriter plattformAccountItemWriter,
        StepExecutionListener plattformAccountStepExecutionListener
    ) {
        stepBuilderFactory.get("convertAccountData").listener(plattformAccountStepExecutionListener)
            .<AccountDto, Account> chunk(10)
            .reader(plattformAccountItemReader)
            .processor(plattformAccountItemProcessor)
            .writer(plattformAccountItemWriter)
            .build()
    }

    @Bean
    Step importLoanDataStep(
        ItemReader plattformLoanItemReader, 
        ItemProcessor plattformLoanItemProcessor, 
        ItemWriter plattformLoanItemWriter,
        StepExecutionListener plattformLoanStepExecutionListener
    ) {
        stepBuilderFactory.get("convertLoanData").listener(plattformLoanStepExecutionListener)
            .<LoanDto, Loan> chunk(10)
            .reader(plattformLoanItemReader)
            .processor(plattformLoanItemProcessor)
            .writer(plattformLoanItemWriter)
            .build()
    }
}
