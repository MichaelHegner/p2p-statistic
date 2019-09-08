package net.hemisoft.p2p.converter.plattform.flender.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.converter.domain.Loan
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.flender.dto.FlenderLoanDto

@Component
public class FlenderLoanItemProcessor extends AbstractLoanItemProcessor<FlenderLoanDto, Loan> {

	@Override Loan process(FlenderLoanDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.FLENDER }
}
