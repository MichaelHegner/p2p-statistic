package net.hemisoft.p2p.importer.plattform.twino

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class TwinoItemProcessor extends AbstractLoanItemProcessor<TwinoTransactionDto, Loan> {

	@Override Loan process(TwinoTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.TWINO }
}
