package net.hemisoft.p2p.converter.plattform.twino.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.converter.domain.Loan
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.twino.dto.TwinoLoanDto

@Component
public class TwinoLoanItemProcessor extends AbstractLoanItemProcessor<TwinoLoanDto, Loan> {

	@Override Loan process(TwinoLoanDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.TWINO }
}
