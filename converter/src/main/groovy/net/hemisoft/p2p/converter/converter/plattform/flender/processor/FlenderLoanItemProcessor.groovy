package net.hemisoft.p2p.converter.converter.plattform.flender.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.converter.converter.plattform.flender.dto.FlenderLoanDto
import net.hemisoft.p2p.converter.domain.entity.Loan
import net.hemisoft.p2p.converter.domain.entity.Plattform

@Component
public class FlenderLoanItemProcessor extends AbstractLoanItemProcessor<FlenderLoanDto, Loan> {

	@Override Loan process(FlenderLoanDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.FLENDER }
}
