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
import org.springframework.batch.item.support.CompositeItemProcessor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Loan
import net.hemisoft.p2p.converter.plattform.dto.AccountDto
import net.hemisoft.p2p.converter.plattform.dto.LoanDto
import net.hemisoft.p2p.converter.plattform.policy.AccountSkipPolicy
import net.hemisoft.p2p.converter.plattform.processor.PlattformAccountTransferStatusFilterProcessor
import net.hemisoft.p2p.converter.plattform.processor.PlattformAccountTransferTypeFilterProcessor
import net.hemisoft.p2p.converter.plattform.processor.PortfolioPerformanceTransferStatusFilterProcessor

@Configuration
@EnableBatchProcessing
public class PlattformConfiguration {
    @Autowired StepBuilderFactory stepBuilderFactory
    @Autowired JobBuilderFactory  jobBuilderFactory


    @Bean
    Job importJob(
            JobExecutionListener jobExecutionListener,
            Step importAccountDataStep,
            Step importLoanDataStep,
            Step importPortfolioPerformanceStep
    ) {
        jobBuilderFactory.get("converterJob")
                .incrementer(RunIdIncrementer.newInstance())
                .listener(jobExecutionListener)
                .start(importAccountDataStep)
                .next(importLoanDataStep)
                .next(importPortfolioPerformanceStep)
                .build() 
    }
    

    @Bean
    Step importAccountDataStep(
            ItemReader plattformAccountItemReader,
            CompositeItemProcessor accountProcessors,
            ItemWriter plattformAccountItemWriter,
            StepExecutionListener plattformAccountStepExecutionListener
    ) {
        stepBuilderFactory.get("convertAccountData")
                .listener(plattformAccountStepExecutionListener)
                .<AccountDto, Account> chunk(10)
                .reader(plattformAccountItemReader)
                .processor(accountProcessors)
                .writer(plattformAccountItemWriter)
                .faultTolerant()
                .skipPolicy(new AccountSkipPolicy())
                .build() 
    }

    @Bean
    Step importLoanDataStep(
            ItemReader plattformLoanItemReader,
            ItemProcessor plattformLoanItemProcessor,
            ItemWriter plattformLoanItemWriter,
            StepExecutionListener plattformLoanStepExecutionListener
    ) {
        stepBuilderFactory.get("convertLoanData")
                .listener(plattformLoanStepExecutionListener)
                .<LoanDto, Loan> chunk(10)
                .reader(plattformLoanItemReader)
                .processor(plattformLoanItemProcessor)
                .writer(plattformLoanItemWriter)
                .build() 
    } 
    
    @Bean
    Step importPortfolioPerformanceStep(
            ItemReader plattformAccountItemReader,
            ItemProcessor portfolioPerformanceProcessors,
            ItemWriter portfolioPerformanceCsvItemWriter,
            StepExecutionListener plattformAccountStepExecutionListener
    ) {
        stepBuilderFactory.get("convertPortfolioPerformanceData")
                .<LoanDto, Loan> chunk(10)
                .reader(plattformAccountItemReader)
                .processor(portfolioPerformanceProcessors)
                .writer(portfolioPerformanceCsvItemWriter)
                .faultTolerant()
                .skipPolicy(new AccountSkipPolicy())
                .build() 
    } 

    
    
    @Bean
    CompositeItemProcessor accountProcessors(
            PlattformAccountTransferTypeFilterProcessor plattformAccountTransferTypeFilterProcessor,
            PlattformAccountTransferStatusFilterProcessor plattformAccountTransferStatusFilterProcessor,
            ItemProcessor plattformAccountItemProcessor
    ) {
                
        List itemProcessors = new ArrayList()
        itemProcessors.add(plattformAccountTransferTypeFilterProcessor)
        itemProcessors.add(plattformAccountTransferStatusFilterProcessor)
        itemProcessors.add(plattformAccountItemProcessor)
        
        CompositeItemProcessor compositeProcessor = new CompositeItemProcessor()
        compositeProcessor.setDelegates(itemProcessors) 
        return compositeProcessor
    }
    
    @Bean
    CompositeItemProcessor portfolioPerformanceProcessors(
            PlattformAccountTransferTypeFilterProcessor plattformAccountTransferTypeFilterProcessor,
            PlattformAccountTransferStatusFilterProcessor plattformAccountTransferStatusFilterProcessor,
            PortfolioPerformanceTransferStatusFilterProcessor portfolioPerformanceTransferStatusFilterProcessor,
            ItemProcessor portfolioPerformanceAccountItemProcessor
    ) {
        
        List itemProcessors = new ArrayList()
        itemProcessors.add(plattformAccountTransferTypeFilterProcessor)
        itemProcessors.add(plattformAccountTransferStatusFilterProcessor)
        itemProcessors.add(portfolioPerformanceTransferStatusFilterProcessor)
        itemProcessors.add(portfolioPerformanceAccountItemProcessor)
        
        CompositeItemProcessor compositeProcessor = new CompositeItemProcessor()
        compositeProcessor.setDelegates(itemProcessors) 
        return compositeProcessor
    }
} 
