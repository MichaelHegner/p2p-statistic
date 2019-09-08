package net.hemisoft.p2p.converter.plattform.investly.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Loan
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.investly.dto.InvestlyLoanDto
import net.hemisoft.p2p.converter.plattform.processor.AbstractLoanItemProcessor

@Component
public class InvestlyLoanItemProcessor extends AbstractLoanItemProcessor<InvestlyLoanDto, Loan> {

	@Override Loan process(InvestlyLoanDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.INVESTLY }
}
