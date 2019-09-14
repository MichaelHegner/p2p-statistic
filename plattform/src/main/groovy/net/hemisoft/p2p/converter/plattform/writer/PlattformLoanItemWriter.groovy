package net.hemisoft.p2p.converter.plattform.writer

import org.springframework.batch.item.ItemWriter
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.service.PlattformLoanImportService

@Component
class PlattformLoanItemWriter implements ItemWriter {
	final PlattformLoanImportService service
	
	PlattformLoanItemWriter(PlattformLoanImportService plattformLoanImportService) {
		this.service = plattformLoanImportService
	}
	
	@Override void write(List items) throws Exception {
		service.saveLoans items
	}
}