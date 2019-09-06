package net.hemisoft.p2p.importer.plattform.estateguru.listener

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.plattform.estateguru.service.EstateguruAccountImportService


@Slf4j
public class EstateguruAccountStepExecutionListener implements StepExecutionListener {
	@Autowired EstateguruAccountImportService service

	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info "Start Estateguru Account Import ...."
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		def accountValue = service.value
		log.info "Estateguru Account Import added $accountValue euro."
	}
}
