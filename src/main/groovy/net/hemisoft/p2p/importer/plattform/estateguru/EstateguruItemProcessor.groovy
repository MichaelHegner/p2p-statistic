package net.hemisoft.p2p.importer.plattform.estateguru

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class EstateguruItemProcessor extends AbstractItemProcessor<EstateguruTransactionDto, Loan> {

	@Override Loan process(EstateguruTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.ESTATEGURU }
	
	def pattern = ~/[A-Z]{2}\d{4}$/
	@Override String createLoanId(EstateguruTransactionDto dto) {
		def matcher = dto.loanId =~ pattern
		def result = (matcher.find()) ? matcher[0] : super.createLoanId(dto)
	}
}
