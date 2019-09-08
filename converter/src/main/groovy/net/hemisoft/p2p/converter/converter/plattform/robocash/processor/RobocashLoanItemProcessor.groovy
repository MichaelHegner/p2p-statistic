package net.hemisoft.p2p.converter.converter.plattform.robocash.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.plattform.robocash.dto.RobocashLoanDto
import net.hemisoft.p2p.converter.domain.entity.Loan
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.processor.AbstractLoanItemProcessor

@Component
public class RobocashLoanItemProcessor extends AbstractLoanItemProcessor<RobocashLoanDto, Loan> {
	@Override Loan process(RobocashLoanDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.ROBOCASH }
	
	@Override String createLoanId(RobocashLoanDto dto) {
		def loanId = dto.loanId
		def endIndex = loanId.indexOf(".")
		endIndex >= 0 ? loanId.substring(0, endIndex) : loanId
	}
}
