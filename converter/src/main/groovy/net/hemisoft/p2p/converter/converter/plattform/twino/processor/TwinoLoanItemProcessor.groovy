package net.hemisoft.p2p.converter.converter.plattform.twino.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.plattform.twino.dto.TwinoLoanDto
import net.hemisoft.p2p.converter.domain.entity.Loan
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.processor.AbstractLoanItemProcessor

@Component
public class TwinoLoanItemProcessor extends AbstractLoanItemProcessor<TwinoLoanDto, Loan> {

	@Override Loan process(TwinoLoanDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.TWINO }
}
