package net.hemisoft.p2p.importer.plattform.neofinance

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class NeofinanceItemProcessor extends AbstractItemProcessor<NeofinanceTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(NeofinanceTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform() { Plattform.NEOFINANCE }
}
