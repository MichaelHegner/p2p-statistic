package net.hemisoft.p2p.converter.plattform.listener

import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.JobExecutionListener
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j

@Slf4j
@Component
class PlattformJobExecutionListener implements JobExecutionListener {
	@Value('${p2p.plattform:UNKNOWN}') String plattform
	
	
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
