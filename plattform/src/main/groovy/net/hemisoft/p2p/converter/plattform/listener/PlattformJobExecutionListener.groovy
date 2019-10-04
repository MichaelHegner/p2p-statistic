package net.hemisoft.p2p.converter.plattform.listener

import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.JobExecutionListener
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.plattform.service.PlattformAccountImportService

@Slf4j
@Component
class PlattformJobExecutionListener implements JobExecutionListener {
	private final PlattformAccountImportService accountService
	
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
			
			def resultMap = accountService.depositMapByYearMonth
			def entrySet = TreeSet.newInstance(resultMap.keySet()).each { 
				log.info "$it: " + resultMap.get(it)
			}
			
			log.info "Result: " + accountService.totalDeposit
		}
	}
}
