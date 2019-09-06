package net.hemisoft.p2p.importer.plattform.finbee

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class FinbeeItemProcessor extends AbstractLoanItemProcessor<FinbeeTransactionDto, Loan> {

	@Override Loan process(FinbeeTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.FINBEE }
}
