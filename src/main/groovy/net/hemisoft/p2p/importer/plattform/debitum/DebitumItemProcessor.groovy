package net.hemisoft.p2p.importer.plattform.debitum

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class DebitumItemProcessor extends AbstractItemProcessor<DebitumTransactionDto, TransactionEntity> {

	@Override TransactionEntity process(DebitumTransactionDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform() { Plattform.DEBITUM }

}
