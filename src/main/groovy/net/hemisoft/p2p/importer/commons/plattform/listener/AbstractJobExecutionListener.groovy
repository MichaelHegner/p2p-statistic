package net.hemisoft.p2p.importer.commons.plattform.listener

import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.JobExecutionListener

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.service.AbstractAccountImportService
import net.hemisoft.p2p.importer.domain.Plattform

@Slf4j
abstract class AbstractJobExecutionListener implements JobExecutionListener {
	Plattform plattform
	AbstractAccountImportService service
	
	AbstractJobExecutionListener(Plattform plattform, AbstractAccountImportService service) {
		this.plattform = plattform
		this.service = service
	}
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		// Nothing to do.
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(BatchStatus.COMPLETED == jobExecution.status) {
			log.info "!!! Import $plattform Job finished. !!!"
		}
	}
}
