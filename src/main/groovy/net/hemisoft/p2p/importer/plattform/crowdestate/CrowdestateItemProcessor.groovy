package net.hemisoft.p2p.importer.plattform.crowdestate

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class CrowdestateItemProcessor extends AbstractItemProcessor<CrowdestateTransactionDto, TransactionEntity> {

	@Override TransactionEntity process(CrowdestateTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform() { Plattform.CROWDESTATE }
}
