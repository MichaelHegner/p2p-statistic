package net.hemisoft.p2p.importer.plattform.debitum

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class DebitumItemProcessor extends AbstractItemProcessor<DebitumTransactionDto, Loan> {

	@Override Loan process(DebitumTransactionDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.DEBITUM }
}
