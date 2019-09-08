package net.hemisoft.p2p.converter.converter.plattform.finbee.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.converter.converter.plattform.finbee.dto.FinbeeLoanDto
import net.hemisoft.p2p.converter.domain.entity.Loan
import net.hemisoft.p2p.converter.domain.entity.Plattform

@Component
public class FinbeeLoanItemProcessor extends AbstractLoanItemProcessor<FinbeeLoanDto, Loan> {

	@Override Loan process(FinbeeLoanDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.FINBEE }
}
