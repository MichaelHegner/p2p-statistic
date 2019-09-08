package net.hemisoft.p2p.converter.converter.plattform.crowdestate.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.converter.converter.plattform.crowdestate.dto.CrowdestateLoanDto
import net.hemisoft.p2p.converter.domain.entity.Loan
import net.hemisoft.p2p.converter.domain.entity.Plattform

@Component
public class CrowdestateLoanItemProcessor extends AbstractLoanItemProcessor<CrowdestateLoanDto, Loan> {

	@Override Loan process(CrowdestateLoanDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.CROWDESTATE }
}
