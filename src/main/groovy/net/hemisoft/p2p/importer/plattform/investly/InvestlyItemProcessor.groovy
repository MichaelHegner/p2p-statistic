package net.hemisoft.p2p.importer.plattform.investly

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class InvestlyItemProcessor extends AbstractItemProcessor<InvestlyTransactionDto, Loan> {

	@Override Loan process(InvestlyTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.INVESTLY }
}
