package net.hemisoft.p2p.converter.converter.plattform.neofinance.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.converter.converter.plattform.neofinance.dto.NeofinanceLoanDto
import net.hemisoft.p2p.converter.domain.entity.Loan
import net.hemisoft.p2p.converter.domain.entity.Plattform

@Component
public class NeofinanceLoanItemProcessor extends AbstractLoanItemProcessor<NeofinanceLoanDto, Loan> {

	@Override
	public Loan process(NeofinanceLoanDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.NEOFINANCE }
}
