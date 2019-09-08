package net.hemisoft.p2p.converter.converter.plattform.debitum.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.converter.converter.plattform.debitum.dto.DebitumLoanDto
import net.hemisoft.p2p.converter.domain.entity.Loan
import net.hemisoft.p2p.converter.domain.entity.Plattform

@Component
public class DebitumLoanItemProcessor extends AbstractLoanItemProcessor<DebitumLoanDto, Loan> {

	@Override Loan process(DebitumLoanDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.DEBITUM }
}
