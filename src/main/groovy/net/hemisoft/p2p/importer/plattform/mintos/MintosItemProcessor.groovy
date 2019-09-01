package net.hemisoft.p2p.importer.plattform.mintos

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class MintosItemProcessor extends AbstractItemProcessor<MintosTransactionDto, TransactionEntity> {

	@Override TransactionEntity process(MintosTransactionDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform() { Plattform.MINTOS }
}
