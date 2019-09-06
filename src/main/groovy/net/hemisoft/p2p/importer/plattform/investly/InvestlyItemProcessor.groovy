package net.hemisoft.p2p.importer.plattform.investly

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class InvestlyItemProcessor extends AbstractLoanItemProcessor<InvestlyTransactionDto, Loan> {

	@Override Loan process(InvestlyTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.INVESTLY }
}
