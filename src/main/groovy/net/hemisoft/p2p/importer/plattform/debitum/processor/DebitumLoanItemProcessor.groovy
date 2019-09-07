package net.hemisoft.p2p.importer.plattform.debitum.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.debitum.dto.DebitumLoanDto

@Component
public class DebitumLoanItemProcessor extends AbstractLoanItemProcessor<DebitumLoanDto, Loan> {

	@Override Loan process(DebitumLoanDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.DEBITUM }
}
