package net.hemisoft.p2p.importer.plattform.mintos

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class MintosItemProcessor extends AbstractLoanItemProcessor<MintosTransactionDto, Loan> {

	@Override Loan process(MintosTransactionDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.MINTOS }
}
