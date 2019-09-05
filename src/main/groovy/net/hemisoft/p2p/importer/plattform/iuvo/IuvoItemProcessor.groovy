package net.hemisoft.p2p.importer.plattform.iuvo

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class IuvoItemProcessor extends AbstractItemProcessor<IuvoTransactionDto, Loan> {

	@Override Loan process(IuvoTransactionDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.IUVO }
	
	@Override String createLoanId(IuvoTransactionDto dto) {
		def loanId = dto.loanId
		def endIndex = loanId.indexOf(".")
		loanId.substring(0, endIndex)
	}

}
