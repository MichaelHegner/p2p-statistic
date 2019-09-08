package net.hemisoft.p2p.converter.plattform.writer

import org.springframework.batch.item.ItemWriter

import net.hemisoft.p2p.converter.plattform.service.AbstractLoanImportService

abstract class AbstractLoanItemWriter implements ItemWriter {
	AbstractLoanImportService service
	
	AbstractLoanItemWriter(AbstractLoanImportService service) {
		this.service = service
	}
	
	@Override void write(List items) throws Exception {
		service.saveLoans items
	}
}
