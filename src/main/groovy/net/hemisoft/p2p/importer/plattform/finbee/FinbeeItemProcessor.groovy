package net.hemisoft.p2p.importer.plattform.finbee

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class FinbeeItemProcessor extends AbstractItemProcessor<FinbeeTransactionDto, TransactionEntity> {

	@Override TransactionEntity process(FinbeeTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform() { Plattform.FINBEE }
}
