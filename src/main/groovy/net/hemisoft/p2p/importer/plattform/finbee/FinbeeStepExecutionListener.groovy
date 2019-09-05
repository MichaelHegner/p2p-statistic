package net.hemisoft.p2p.importer.plattform.finbee

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j


@Slf4j
public class FinbeeStepExecutionListener implements StepExecutionListener {
	@Autowired FinbeeImportService service

	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info "Start Finbee Import ...."
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		def numberOfLoans = service.countLoans()
		log.info "Finbee Import added $numberOfLoans loans."
	}
}
