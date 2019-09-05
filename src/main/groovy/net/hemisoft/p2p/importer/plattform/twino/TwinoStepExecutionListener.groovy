package net.hemisoft.p2p.importer.plattform.twino

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j


@Slf4j
public class TwinoStepExecutionListener implements StepExecutionListener {
	@Autowired TwinoImportService service

	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info "Start Twino Import ...."
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		def numberOfLoans = service.countLoans()
		log.info "Twino Import added $numberOfLoans loans."
	}
}
