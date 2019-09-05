package net.hemisoft.p2p.importer.plattform.mintos

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j


@Slf4j
public class MintosStepExecutionListener implements StepExecutionListener {
	@Autowired MintosImportService service

	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info "Start Mintos Import ...."
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		def numberOfLoans = service.countLoans()
		log.info "Mintos Import added $numberOfLoans loans."
	}
}
