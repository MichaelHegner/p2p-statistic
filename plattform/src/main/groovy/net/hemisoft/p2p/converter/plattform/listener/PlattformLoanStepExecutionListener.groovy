package net.hemisoft.p2p.converter.plattform.listener

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.plattform.service.PlattformLoanImportService

@Slf4j
@Component
class PlattformLoanStepExecutionListener implements StepExecutionListener {
	@Value('${p2p.plattform:UNKNOWN}') String plattform
	
	final PlattformLoanImportService service
	
	PlattformLoanStepExecutionListener(PlattformLoanImportService plattformLoanImportService) {
		this.service = plattformLoanImportService
	}
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info "Start $plattform Loan Import ...."
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		def numberOfLoans = service.countLoans()
		log.info "$plattform Loan Import added $numberOfLoans loans."
	}
}
