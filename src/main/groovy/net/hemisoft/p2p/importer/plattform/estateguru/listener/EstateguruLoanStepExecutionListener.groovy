package net.hemisoft.p2p.importer.plattform.estateguru.listener

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.plattform.estateguru.service.EstateguruLoanImportService


@Slf4j
public class EstateguruLoanStepExecutionListener implements StepExecutionListener {
	@Autowired EstateguruLoanImportService service

	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info "Start Estateguru Loan Import ...."
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		def numberOfLoans = service.countLoans()
		log.info "Estateguru Loan Import added $numberOfLoans loans."
	}
}
