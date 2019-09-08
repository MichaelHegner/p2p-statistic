package net.hemisoft.p2p.importer.plattform.iuvo.processor

import org.apache.commons.lang3.StringUtils
import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.iuvo.dto.IuvoLoanDto

@Component
public class IuvoLoanItemProcessor extends AbstractLoanItemProcessor<IuvoLoanDto, Loan> {

	@Override Loan process(IuvoLoanDto dto) throws Exception {
		def loanId = dto.loanId
		if(StringUtils.isBlank(loanId) || loanId == "-") return null
		
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.IUVO }
	
	@Override String createLoanId(IuvoLoanDto dto) {
		def loanId = dto.loanId
		def endIndex = loanId.indexOf(".")
		loanId.substring(0, endIndex)
	}

}