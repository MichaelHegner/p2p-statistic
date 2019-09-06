package net.hemisoft.p2p.importer.plattform.debitum.writer

import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.plattform.debitum.service.DebitumLoanImportService

@Slf4j
public class DebitumLoanItemWriter implements ItemWriter {
	@Autowired DebitumLoanImportService service
	
	@Override void write(List items) throws Exception {
		service.saveLoans items
	}
}
