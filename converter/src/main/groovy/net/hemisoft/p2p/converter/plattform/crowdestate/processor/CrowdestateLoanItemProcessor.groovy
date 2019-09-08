package net.hemisoft.p2p.converter.plattform.crowdestate.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.converter.domain.Loan
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.crowdestate.dto.CrowdestateLoanDto

@Component
public class CrowdestateLoanItemProcessor extends AbstractLoanItemProcessor<CrowdestateLoanDto, Loan> {

	@Override Loan process(CrowdestateLoanDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.CROWDESTATE }
}
