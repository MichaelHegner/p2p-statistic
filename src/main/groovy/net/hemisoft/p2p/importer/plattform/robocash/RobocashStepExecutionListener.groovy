package net.hemisoft.p2p.importer.plattform.robocash

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j


@Slf4j
public class RobocashStepExecutionListener implements StepExecutionListener {
	@Autowired RobocashImportService service

	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info "Start Robocash Import ...."
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		def numberOfLoans = service.countLoans()
		log.info "Robocash Import added $numberOfLoans loans."
	}
}
