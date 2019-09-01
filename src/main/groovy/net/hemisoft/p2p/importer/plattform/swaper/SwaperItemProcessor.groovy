package net.hemisoft.p2p.importer.plattform.swaper

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class SwaperItemProcessor extends AbstractItemProcessor<SwaperTransactionDto, TransactionEntity> {

	@Override TransactionEntity process(SwaperTransactionDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform() { Plattform.SWAPER }

}
