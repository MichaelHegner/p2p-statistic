package net.hemisoft.p2p.converter.plattform.listener

import static java.math.BigDecimal.ZERO
import static org.apache.commons.lang3.math.NumberUtils.LONG_ONE

import java.text.NumberFormat
import java.time.Month
import java.time.YearMonth

import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.JobExecutionListener
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.domain.entity.TransferType
import net.hemisoft.p2p.converter.plattform.service.PlattformAccountImportService

@Slf4j
@Component
class PlattformJobExecutionListener implements JobExecutionListener {
    private final PlattformAccountImportService accountService
    private final List<YearMonth> yearmonthList = []
    
    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.GERMANY)
    
    @Value('${p2p.plattform:UNKNOWN}') String plattform
    
    
    PlattformJobExecutionListener(PlattformAccountImportService accountService) {
        this.accountService = accountService
    }

    
    @Override
    public void beforeJob(JobExecution jobExecution) {
        // Nothing to do.
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(BatchStatus.COMPLETED == jobExecution.status) {
            log.info "!!! Import $plattform Job finished. !!!"
            
            initializeAfterJob()
            
            
            def totalVolume = ZERO
            yearmonthList.each { 
                if(log.infoEnabled) {
                    def deposit    = accountService.depositMapByYearMonth.getOrDefault    it, 0.0
                    def withdrawal = accountService.withdrawalMapByYearMonth.getOrDefault it, 0.0
                    def investment = accountService.investmentMapByYearMonth.getOrDefault it, 0.0
                    def principal  = accountService.principleMapByYearMonth.getOrDefault  it, 0.0
                    def earning    = accountService.earningMapByYearMonth.getOrDefault    it, 0.0
                    
                    def beforeMonthYear  = it.minusMonths LONG_ONE
                    def depositBefore    = accountService.depositMapByYearMonth.getOrDefault beforeMonthYear, 0.0
                    def earningBefore    = accountService.earningMapByYearMonth.getOrDefault beforeMonthYear, 0.0
                    
                    totalVolume = totalVolume + ( deposit - withdrawal ) + earning

                                        log.info (
                        "$it: " 
                        + TransferType.DEPOSIT.name()    + ": " + formatCurrency(deposit)     + "\t" 
                        + TransferType.WITHDRAW.name()   + ": " + formatCurrency(withdrawal)  + "\t"   
                        + TransferType.INVESTMENT.name() + ": " + formatCurrency(investment)  + "\t"  
                        + TransferType.PRINCIPAL.name()  + ": " + formatCurrency(principal)   + "\t" 
                        + TransferType.EARNING.name()    + ": " + formatCurrency(earning)     + "\t"
                        
                        + "VOLUME: "                            + formatCurrency(totalVolume) + "\t"
                    )
                    
                }
            }
            
            if(log.infoEnabled) {
                log.info "===================================="
                log.info "DEPOSIT TOTAL:    " + formatCurrency(accountService.totalDeposit)
                log.info "WITHDRAWAL TOTAL: " + formatCurrency(accountService.totalWithdrawal)
                log.info "INVESTMENT TOTAL: " + formatCurrency(accountService.totalInvestment)
                log.info "PRINCIPAL TOTAL:  " + formatCurrency(accountService.totalPrincipal)
                log.info "EARNINGS TOTAL:   " + formatCurrency(accountService.totalEarning)
                
                log.info "VOLUME TOTAL:     "   + formatCurrency(totalVolume)
                log.info "===================================="
            }
        }
    }
    
    private void initializeAfterJob() {
        for(int tempYear = getOldestYearMonth().getYear(); tempYear <= YearMonth.now().getYear(); tempYear++) {
            for(Month tempMonth : Month.values()) {
                def tempYearMonth = YearMonth.of tempYear, tempMonth
                        yearmonthList.add tempYearMonth
            }
        }
    }
    
    
    private YearMonth getOldestYearMonth() {
        Set treeSet = new TreeSet()
        treeSet.addAll(accountService.depositMapByYearMonth.keySet())
        treeSet.addAll(accountService.withdrawalMapByYearMonth.keySet())
        treeSet.addAll(accountService.earningMapByYearMonth.keySet())
        treeSet.addAll(accountService.investmentMapByYearMonth.keySet())
        treeSet.addAll(accountService.principleMapByYearMonth.keySet())
        
        treeSet.getAt(0) ?: YearMonth.now()
    } 
    
    private String formatCurrency(BigDecimal amount) {
        def amountAsString = String.valueOf amount
        def formatted      = formatter.format amount
        def padded         = formatted.padLeft(12)
            padded
    }
}
