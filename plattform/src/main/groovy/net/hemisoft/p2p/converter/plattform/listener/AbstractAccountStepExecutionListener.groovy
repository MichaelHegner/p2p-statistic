package net.hemisoft.p2p.converter.plattform.listener

import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.StepExecutionListener

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.service.AbstractAccountImportService

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
