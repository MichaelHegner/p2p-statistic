package net.hemisoft.p2p.importer.plattform.flender

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class FlenderItemProcessor extends AbstractLoanItemProcessor<FlenderTransactionDto, Loan> {

	@Override Loan process(FlenderTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.FLENDER }
}
