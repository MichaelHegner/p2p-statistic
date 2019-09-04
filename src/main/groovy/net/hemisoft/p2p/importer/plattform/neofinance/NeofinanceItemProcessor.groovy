package net.hemisoft.p2p.importer.plattform.neofinance

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class NeofinanceItemProcessor extends AbstractItemProcessor<NeofinanceTransactionDto, Loan> {

	@Override
	public Loan process(NeofinanceTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.NEOFINANCE }
}
