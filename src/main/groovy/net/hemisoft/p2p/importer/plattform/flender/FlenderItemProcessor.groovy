package net.hemisoft.p2p.importer.plattform.flender

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class FlenderItemProcessor extends AbstractItemProcessor<FlenderTransactionDto, Loan> {

	@Override Loan process(FlenderTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.FLENDER }
}
