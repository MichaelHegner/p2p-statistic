package net.hemisoft.p2p.importer.plattform.investly

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class InvestlyItemProcessor extends AbstractItemProcessor<InvestlyTransactionDto, TransactionEntity> {

	@Override TransactionEntity process(InvestlyTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform() { Plattform.INVESTLY }
}
