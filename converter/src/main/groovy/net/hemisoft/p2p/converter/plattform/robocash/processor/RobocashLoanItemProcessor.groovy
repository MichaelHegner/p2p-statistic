package net.hemisoft.p2p.converter.plattform.robocash.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.converter.domain.Loan
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.robocash.dto.RobocashLoanDto

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
