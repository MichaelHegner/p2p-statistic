package net.hemisoft.p2p.importer.plattform.iuvo

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class IuvoItemProcessor extends AbstractItemProcessor<IuvoTransactionDto, TransactionEntity> {

	@Override TransactionEntity process(IuvoTransactionDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform() { Plattform.IUVO }
}
