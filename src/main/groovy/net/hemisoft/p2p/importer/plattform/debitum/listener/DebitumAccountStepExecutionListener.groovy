package net.hemisoft.p2p.importer.plattform.debitum.listener

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.plattform.debitum.service.DebitumAccountImportService


@Slf4j
public class DebitumAccountStepExecutionListener implements StepExecutionListener {
	@Autowired DebitumAccountImportService service

	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info "Start Debitum Account Import ...."
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		def accountValue = service.value
		log.info "Debitum Account Import added $accountValue euro."
	}
}
