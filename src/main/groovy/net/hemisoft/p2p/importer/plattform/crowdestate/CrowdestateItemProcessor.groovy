package net.hemisoft.p2p.importer.plattform.crowdestate

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class CrowdestateItemProcessor extends AbstractItemProcessor<CrowdestateTransactionDto, Loan> {

	@Override Loan process(CrowdestateTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.CROWDESTATE }
}
