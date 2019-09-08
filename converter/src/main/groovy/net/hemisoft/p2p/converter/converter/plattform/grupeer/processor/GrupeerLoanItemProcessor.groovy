package net.hemisoft.p2p.converter.converter.plattform.grupeer.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.converter.converter.plattform.grupeer.dto.GrupeerLoanDto
import net.hemisoft.p2p.converter.domain.entity.Loan
import net.hemisoft.p2p.converter.domain.entity.Plattform

@Component
public class GrupeerLoanItemProcessor extends AbstractLoanItemProcessor<GrupeerLoanDto, Loan> {

	@Override Loan process(GrupeerLoanDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.GRUPEER }
}
