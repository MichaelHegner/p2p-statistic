package net.hemisoft.p2p.converter.plattform.bondora.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Loan
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.bondora.dto.BondoraLoanDto
import net.hemisoft.p2p.converter.plattform.processor.AbstractLoanItemProcessor

@Component
public class BondoraLoanItemProcessor extends AbstractLoanItemProcessor<BondoraLoanDto, Loan> {
	@Override Loan process(BondoraLoanDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.BONDORA }
}
