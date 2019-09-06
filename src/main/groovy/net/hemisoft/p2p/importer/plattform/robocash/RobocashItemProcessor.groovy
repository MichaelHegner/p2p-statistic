package net.hemisoft.p2p.importer.plattform.robocash

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class RobocashItemProcessor extends AbstractLoanItemProcessor<RobocashTransactionDto, Loan> {

	@Override Loan process(RobocashTransactionDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.ROBOCASH }
	
	@Override String createLoanId(RobocashTransactionDto dto) {
		def loanId = dto.loanId
		def endIndex = loanId.indexOf(".")
		endIndex >= 0 ? loanId.substring(0, endIndex) : loanId
	}

}
