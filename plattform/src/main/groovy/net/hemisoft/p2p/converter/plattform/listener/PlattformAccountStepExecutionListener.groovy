package net.hemisoft.p2p.converter.plattform.listener

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.plattform.service.PlattformAccountImportService

@Slf4j
@Component
class PlattformAccountStepExecutionListener implements StepExecutionListener {
	@Value('${p2p.plattform:UNKNOWN}') String plattform
	
	final PlattformAccountImportService service
	
	PlattformAccountStepExecutionListener(PlattformAccountImportService plattformAccountImportService) {
		this.service = plattformAccountImportService
	}
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info "Start $plattform Account Import ...."
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		def accountValue = service.totalDeposit
		log.info "$plattform Account Import added $accountValue euro."
	}
}
