package net.hemisoft.p2p.importer.plattform.bondora

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j


@Slf4j
public class BondoraStepExecutionListener implements StepExecutionListener {
	@Autowired BondoraImportService service

	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info "Start Bondora Import ...."
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		def numberOfLoans = service.countLoans()
		log.info "Bondora Import added $numberOfLoans loans."
	}
}
