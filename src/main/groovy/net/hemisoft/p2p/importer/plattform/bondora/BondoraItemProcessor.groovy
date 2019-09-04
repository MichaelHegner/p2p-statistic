package net.hemisoft.p2p.importer.plattform.bondora

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class BondoraItemProcessor extends AbstractItemProcessor<BondoraTransactionDto, Loan> {

	@Override Loan process(BondoraTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.BONDORA }
}
