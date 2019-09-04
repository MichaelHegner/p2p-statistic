package net.hemisoft.p2p.importer.plattform.viventor

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class ViventorItemProcessor extends AbstractItemProcessor<ViventorTransactionDto, Loan> {

	@Override Loan process(ViventorTransactionDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.VIVENTOR }
}
