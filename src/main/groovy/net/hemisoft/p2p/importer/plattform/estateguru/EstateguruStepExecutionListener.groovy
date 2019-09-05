package net.hemisoft.p2p.importer.plattform.estateguru

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j


@Slf4j
public class EstateguruStepExecutionListener implements StepExecutionListener {
	@Autowired EstateguruImportService service

	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info "Start Estateguru Import ...."
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		def numberOfLoans = service.countLoans()
		log.info "Estateguru Import added $numberOfLoans loans."
	}
}
