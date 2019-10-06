package net.hemisoft.p2p.converter.plattform.processor

import static org.apache.commons.lang3.StringUtils.isBlank

import java.util.regex.Pattern

import org.springframework.batch.item.ItemProcessor
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Loan
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.dto.LoanDto
import net.hemisoft.p2p.converter.utils.date.P2PDateConversionUtils
import net.hemisoft.p2p.converter.utils.numbers.P2PNumberUtils

@Component
class PlattformLoanItemProcessor implements ItemProcessor<LoanDto, Loan> {
	@Value('${p2p.plattform:UNKNOWN}') String plattform

	@Override Loan process(LoanDto dto) throws Exception {
		def loanId = dto.loanId
		isBlank(loanId) || loanId == "-" ? null : createPopulated(dto)
	}
	
	Loan createPopulated(LoanDto dto) {
		def entity            = new Loan()
		entity.loanId         = createLoanId dto
		entity.investedAmount = P2PNumberUtils.createDoubleIfPossible dto.investedAmount
		entity.issued         = P2PDateConversionUtils.createLocalDateIfPossible dto.issuedDate
		entity.plattform      = Plattform.valueOf(plattform.toUpperCase())
		entity
	}
	
	@Value('${format.regex.loan.id:@null}') String loanIdPattern
	protected String createLoanId(LoanDto dto) {
		if(isBlank(loanIdPattern)) dto.loanId
		else {
			def pattern = Pattern.compile(loanIdPattern)
			def matcher = pattern.matcher(dto.loanId)
			matcher.find() ? matcher.group(0) : dto.loanId
		}
	}

}