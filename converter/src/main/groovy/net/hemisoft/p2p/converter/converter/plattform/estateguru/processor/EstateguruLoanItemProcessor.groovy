package net.hemisoft.p2p.converter.converter.plattform.estateguru.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.plattform.estateguru.dto.EstateguruLoanDto
import net.hemisoft.p2p.converter.domain.entity.Loan
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.processor.AbstractLoanItemProcessor

@Component
public class EstateguruLoanItemProcessor extends AbstractLoanItemProcessor<EstateguruLoanDto, Loan> {

	@Override Loan process(EstateguruLoanDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.ESTATEGURU }
	
	def pattern = ~/[A-Z]{2}\d{4}$/
	@Override String createLoanId(EstateguruLoanDto dto) {
		def matcher = dto.loanId =~ pattern
		def result = (matcher.find()) ? matcher[0] : super.createLoanId(dto)
	}
}
