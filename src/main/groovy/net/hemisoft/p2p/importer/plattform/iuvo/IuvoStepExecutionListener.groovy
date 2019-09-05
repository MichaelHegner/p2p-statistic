package net.hemisoft.p2p.importer.plattform.iuvo

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j


@Slf4j
public class IuvoStepExecutionListener implements StepExecutionListener {
	@Autowired IuvoImportService service

	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info "Start Iuvo Import ...."
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		def numberOfLoans = service.countLoans()
		log.info "Iuvo Import added $numberOfLoans loans."
	}
}
