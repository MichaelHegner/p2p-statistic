package net.hemisoft.p2p.converter.plattform.debitum.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.converter.domain.Loan
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.debitum.dto.DebitumLoanDto

@Component
public class DebitumLoanItemProcessor extends AbstractLoanItemProcessor<DebitumLoanDto, Loan> {

	@Override Loan process(DebitumLoanDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.DEBITUM }
}
