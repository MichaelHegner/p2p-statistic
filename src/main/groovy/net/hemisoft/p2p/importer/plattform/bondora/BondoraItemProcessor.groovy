package net.hemisoft.p2p.importer.plattform.bondora

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class BondoraItemProcessor extends AbstractItemProcessor<BondoraTransactionDto, TransactionEntity> {

	@Override public TransactionEntity process(BondoraTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform() { Plattform.BONDORA }
}
