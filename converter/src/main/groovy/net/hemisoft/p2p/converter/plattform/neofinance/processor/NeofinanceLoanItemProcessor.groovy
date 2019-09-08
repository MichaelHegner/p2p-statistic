package net.hemisoft.p2p.converter.plattform.neofinance.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.converter.domain.Loan
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.neofinance.dto.NeofinanceLoanDto

@Component
public class NeofinanceLoanItemProcessor extends AbstractLoanItemProcessor<NeofinanceLoanDto, Loan> {

	@Override
	public Loan process(NeofinanceLoanDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.NEOFINANCE }
}
