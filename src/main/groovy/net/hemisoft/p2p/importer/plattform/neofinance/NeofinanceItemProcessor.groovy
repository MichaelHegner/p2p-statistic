package net.hemisoft.p2p.importer.plattform.neofinance

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class NeofinanceItemProcessor extends AbstractLoanItemProcessor<NeofinanceTransactionDto, Loan> {

	@Override
	public Loan process(NeofinanceTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.NEOFINANCE }
}
