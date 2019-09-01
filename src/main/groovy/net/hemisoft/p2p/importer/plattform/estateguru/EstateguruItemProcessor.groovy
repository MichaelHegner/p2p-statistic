package net.hemisoft.p2p.importer.plattform.estateguru

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class EstateguruItemProcessor extends AbstractItemProcessor<EstateguruTransactionDto, TransactionEntity> {

	@Override TransactionEntity process(EstateguruTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform() { Plattform.ESTATEGURU }
}
