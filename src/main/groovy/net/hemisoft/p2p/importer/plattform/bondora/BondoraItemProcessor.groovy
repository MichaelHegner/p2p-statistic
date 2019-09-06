package net.hemisoft.p2p.importer.plattform.bondora

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class BondoraItemProcessor extends AbstractLoanItemProcessor<BondoraTransactionDto, Loan> {

	@Override Loan process(BondoraTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.BONDORA }
}
