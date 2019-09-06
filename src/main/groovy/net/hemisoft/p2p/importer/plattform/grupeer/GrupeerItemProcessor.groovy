package net.hemisoft.p2p.importer.plattform.grupeer

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class GrupeerItemProcessor extends AbstractLoanItemProcessor<GrupeerTransactionDto, Loan> {

	@Override Loan process(GrupeerTransactionDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.GRUPEER }
}
