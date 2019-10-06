package net.hemisoft.p2p.converter.plattform.listener

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
			yearmonthList.each { 
				if(log.infoEnabled) {
					def deposit    = accountService.depositMapByYearMonth.getOrDefault    it, 0.0
					def withdrawal = accountService.withdrawalMapByYearMonth.getOrDefault it, 0.0
					def investment = accountService.investmentMapByYearMonth.getOrDefault it, 0.0
					def principal  = accountService.principleMapByYearMonth.getOrDefault  it, 0.0
					def earning    = accountService.earningMapByYearMonth.getOrDefault    it, 0.0
					
					log.info (
						"$it: " 
					    + TransferType.DEPOSIT.name()    + ": " + formatCurrency(deposit)    + "\t" 
					    + TransferType.WITHDRAW.name()   + ": " + formatCurrency(withdrawal) + "\t"   
					    + TransferType.INVESTMENT.name() + ": " + formatCurrency(investment) + "\t"  
					    + TransferType.PRINCIPAL.name()  + ": " + formatCurrency(principal)  + "\t" 
						+ TransferType.EARNING.name()    + ": " + formatCurrency(earning)  + "\t"
					)
				}
			}
			
			if(log.infoEnabled) {
				log.info "DEPOSIT TOTAL:    " + accountService.totalDeposit
				log.info "WITHDRAWAL TOTAL: " + accountService.totalWithdrawal
				log.info "INVESTMENT TOTAL: " + accountService.totalInvestment
				log.info "PRINCIPAL TOTAL:  " + accountService.totalPrincipal
				log.info "EARNINGS TOTAL:   " + accountService.totalEarning
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
		treeSet.getAt 0
	} 
	
	private String formatCurrency(double amount) {
		def amountAsString = String.valueOf amount
		def formatted      = formatter.format amount
		def padded         = formatted.padLeft(10)
		    padded
	}
}
