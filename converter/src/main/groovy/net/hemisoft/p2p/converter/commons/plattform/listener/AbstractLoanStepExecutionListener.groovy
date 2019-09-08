package net.hemisoft.p2p.converter.commons.plattform.listener

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.service.AbstractLoanImportService
import net.hemisoft.p2p.converter.domain.Plattform

@Slf4j
abstract class AbstractLoanStepExecutionListener implements StepExecutionListener {
	Plattform plattform
	AbstractLoanImportService service
	
	AbstractLoanStepExecutionListener(Plattform plattform, AbstractLoanImportService service) {
		this.plattform = plattform
		this.service = service
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
