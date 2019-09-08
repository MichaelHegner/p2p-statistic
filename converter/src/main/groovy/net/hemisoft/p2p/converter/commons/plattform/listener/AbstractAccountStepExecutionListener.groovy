package net.hemisoft.p2p.converter.commons.plattform.listener

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.service.AbstractAccountImportService
import net.hemisoft.p2p.converter.domain.Plattform

@Slf4j
abstract class AbstractAccountStepExecutionListener implements StepExecutionListener {
	Plattform plattform
	AbstractAccountImportService service
	
	AbstractAccountStepExecutionListener(Plattform plattform, AbstractAccountImportService service) {
		this.plattform = plattform
		this.service = service
	}
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info "Start $plattform Account Import ...."
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		def accountValue = service.value
		log.info "$plattform Account Import added $accountValue euro."
	}
}
