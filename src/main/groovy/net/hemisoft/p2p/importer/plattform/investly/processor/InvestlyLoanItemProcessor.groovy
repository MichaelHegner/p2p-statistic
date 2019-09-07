package net.hemisoft.p2p.importer.plattform.investly.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.investly.dto.InvestlyLoanDto

@Component
public class InvestlyLoanItemProcessor extends AbstractLoanItemProcessor<InvestlyLoanDto, Loan> {

	@Override Loan process(InvestlyLoanDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.INVESTLY }
}
