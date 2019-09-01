package net.hemisoft.p2p.importer.plattform.viventor

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class ViventorItemProcessor extends AbstractItemProcessor<ViventorTransactionDto, TransactionEntity> {

	@Override TransactionEntity process(ViventorTransactionDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform() { Plattform.VIVENTOR }
}
