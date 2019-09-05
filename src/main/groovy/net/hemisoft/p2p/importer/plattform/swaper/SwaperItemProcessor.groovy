package net.hemisoft.p2p.importer.plattform.swaper

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class SwaperItemProcessor extends AbstractItemProcessor<SwaperTransactionDto, Loan> {

	@Override Loan process(SwaperTransactionDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.SWAPER }
	
	@Override String createLoanId(SwaperTransactionDto dto) {
		def loanId = dto.loanId
		
		if (null == loanId) null
		else loanId.substring(0, loanId.indexOf("."))
	}

}
