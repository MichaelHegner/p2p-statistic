package net.hemisoft.p2p.converter.plattform.investly.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.converter.domain.Loan
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.investly.dto.InvestlyLoanDto

@Component
public class InvestlyLoanItemProcessor extends AbstractLoanItemProcessor<InvestlyLoanDto, Loan> {

	@Override Loan process(InvestlyLoanDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.INVESTLY }
}
