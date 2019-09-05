package net.hemisoft.p2p.importer.plattform.peerberry

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j


@Slf4j
public class PeerberryStepExecutionListener implements StepExecutionListener {
	@Autowired PeerberryImportService service

	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info "Start Peerberry Import ...."
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		def numberOfLoans = service.countLoans()
		log.info "Peerberry Import added $numberOfLoans loans."
	}
}
