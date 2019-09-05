package net.hemisoft.p2p.importer.plattform.grupeer

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j


@Slf4j
public class GrupeerStepExecutionListener implements StepExecutionListener {
	@Autowired GrupeerImportService service

	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info "Start Grupeer Import ...."
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		def numberOfLoans = service.countLoans()
		log.info "Grupeer Import added $numberOfLoans loans."
	}
}
