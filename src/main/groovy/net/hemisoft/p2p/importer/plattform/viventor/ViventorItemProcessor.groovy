package net.hemisoft.p2p.importer.plattform.viventor

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class ViventorItemProcessor extends AbstractLoanItemProcessor<ViventorTransactionDto, Loan> {

	@Override Loan process(ViventorTransactionDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.VIVENTOR }
	
	def pattern = ~/\d{6}$/
	@Override String createLoanId(ViventorTransactionDto dto) {
		def matcher = dto.loanId =~ pattern
		def result = (matcher.find()) ? matcher[0] : super.createLoanId(dto)
	}
}
