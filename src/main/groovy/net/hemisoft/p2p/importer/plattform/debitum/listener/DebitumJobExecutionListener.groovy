package net.hemisoft.p2p.importer.plattform.debitum.listener

import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.JobExecutionListener
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.plattform.debitum.service.DebitumLoanImportService


@Slf4j
public class DebitumJobExecutionListener implements JobExecutionListener {
	@Autowired DebitumLoanImportService service

	@Override
	public void beforeJob(JobExecution jobExecution) {
		// Nothing to do.
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(BatchStatus.COMPLETED == jobExecution.status) {
			log.info "!!! Import Debitum Job finished. !!!"
		}
	}
}
