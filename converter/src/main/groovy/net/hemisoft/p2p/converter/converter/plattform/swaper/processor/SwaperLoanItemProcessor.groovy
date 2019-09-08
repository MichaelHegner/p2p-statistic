package net.hemisoft.p2p.converter.converter.plattform.swaper.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.plattform.swaper.dto.SwaperLoanDto
import net.hemisoft.p2p.converter.domain.entity.Loan
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.processor.AbstractLoanItemProcessor

@Component
public class SwaperLoanItemProcessor extends AbstractLoanItemProcessor<SwaperLoanDto, Loan> {

	@Override Loan process(SwaperLoanDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.SWAPER }
	
	@Override String createLoanId(SwaperLoanDto dto) {
		def loanId = dto.loanId
		
		if (null == loanId) null
		else loanId.substring(0, loanId.indexOf("."))
	}

}
