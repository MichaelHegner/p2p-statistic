package net.hemisoft.p2p.converter.plattform.grupeer.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.converter.domain.Loan
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.grupeer.dto.GrupeerLoanDto

@Component
public class GrupeerLoanItemProcessor extends AbstractLoanItemProcessor<GrupeerLoanDto, Loan> {

	@Override Loan process(GrupeerLoanDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.GRUPEER }
}
