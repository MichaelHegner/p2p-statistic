package net.hemisoft.p2p.importer.plattform.debitum

import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.listener.JobExecutionListenerSupport

import groovy.util.logging.Slf4j

@Slf4j
public class DebitumJobCompletionNotificationListener extends JobExecutionListenerSupport {
	@Override
		public void afterJob(JobExecution jobExecution) {
			super.afterJob(jobExecution)
			
			if(BatchStatus.COMPLETED == jobExecution.status) {
				log.info "!!! Debitum Import Job finished. !!!"
			}
 		}
}
