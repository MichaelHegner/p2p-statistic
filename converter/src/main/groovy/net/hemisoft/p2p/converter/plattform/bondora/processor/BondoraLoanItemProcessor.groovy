package net.hemisoft.p2p.converter.plattform.bondora.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.converter.domain.Loan
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.bondora.dto.BondoraLoanDto

@Component
public class BondoraLoanItemProcessor extends AbstractLoanItemProcessor<BondoraLoanDto, Loan> {
	@Override Loan process(BondoraLoanDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.BONDORA }
}
