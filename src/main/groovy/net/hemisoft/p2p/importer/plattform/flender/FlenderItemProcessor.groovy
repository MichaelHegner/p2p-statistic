package net.hemisoft.p2p.importer.plattform.flender

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class FlenderItemProcessor extends AbstractItemProcessor<FlenderTransactionDto, TransactionEntity> {

	@Override TransactionEntity process(FlenderTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform() { Plattform.FLENDER }
}
