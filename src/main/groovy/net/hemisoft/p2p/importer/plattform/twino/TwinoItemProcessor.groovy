package net.hemisoft.p2p.importer.plattform.twino

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class TwinoItemProcessor extends AbstractItemProcessor<TwinoTransactionDto, TransactionEntity> {

	@Override TransactionEntity process(TwinoTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform() { Plattform.TWINO }
}
