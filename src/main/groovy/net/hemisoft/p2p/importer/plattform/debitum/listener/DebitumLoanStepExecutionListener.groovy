package net.hemisoft.p2p.importer.plattform.debitum.listener

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.plattform.debitum.service.DebitumLoanImportService


@Slf4j
public class DebitumLoanStepExecutionListener implements StepExecutionListener {
	@Autowired DebitumLoanImportService service

	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info "Start Debitum Loan Import ...."
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		def numberOfLoans = service.countLoans()
		log.info "Debitum Loan Import added $numberOfLoans loans."
	}
}
