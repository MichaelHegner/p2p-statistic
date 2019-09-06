package net.hemisoft.p2p.importer.plattform.estateguru.listener

import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.JobExecutionListener
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.plattform.estateguru.service.EstateguruLoanImportService


@Slf4j
public class EstateguruJobExecutionListener implements JobExecutionListener {
	@Autowired EstateguruLoanImportService service

	@Override
	public void beforeJob(JobExecution jobExecution) {
		// Nothing to do.
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(BatchStatus.COMPLETED == jobExecution.status) {
			log.info "!!! Import Estateguru Job finished. !!!"
		}
	}
}
