package net.hemisoft.p2p.importer.plattform.crowdestate.listener

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.plattform.crowdestate.service.CrowdestateLoanImportService


@Slf4j
public class CrowdestateLoanStepExecutionListener implements StepExecutionListener {
	@Autowired CrowdestateLoanImportService service

	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info "Start Crowdestate Loan Import ...."
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		def numberOfLoans = service.countLoans()
		log.info "Crowdestate Loan Import added $numberOfLoans loans."
	}
}
