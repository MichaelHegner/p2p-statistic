package net.hemisoft.p2p.importer.plattform.grupeer

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class GrupeerItemProcessor extends AbstractItemProcessor<GrupeerTransactionDto, TransactionEntity> {

	@Override TransactionEntity process(GrupeerTransactionDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform() { Plattform.GRUPEER }

}
