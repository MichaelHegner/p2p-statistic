package net.hemisoft.p2p.importer.plattform.crowdestate.listener

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.plattform.crowdestate.service.CrowdestateAccountImportService


@Slf4j
public class CrowdestateAccountStepExecutionListener implements StepExecutionListener {
	@Autowired CrowdestateAccountImportService service

	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info "Start Crowdestate Account Import ...."
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		def accountValue = service.value
		log.info "Crowdestate Account Import added $accountValue euro."
	}
}
