package net.hemisoft.p2p.importer.plattform.swaper

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j


@Slf4j
public class SwaperStepExecutionListener implements StepExecutionListener {
	@Autowired SwaperImportService service

	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info "Start Swaper Import ...."
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		def numberOfLoans = service.countLoans()
		log.info "Swaper Import added $numberOfLoans loans."
	}
}
