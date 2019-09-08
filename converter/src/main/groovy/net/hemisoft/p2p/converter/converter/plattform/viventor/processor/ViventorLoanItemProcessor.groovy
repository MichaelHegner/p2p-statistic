package net.hemisoft.p2p.converter.converter.plattform.viventor.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.plattform.viventor.dto.ViventorLoanDto
import net.hemisoft.p2p.converter.domain.entity.Loan
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.processor.AbstractLoanItemProcessor

@Component
public class ViventorLoanItemProcessor extends AbstractLoanItemProcessor<ViventorLoanDto, Loan> {

	@Override Loan process(ViventorLoanDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.VIVENTOR }
	
	def pattern = ~/\d{6}$/
	@Override String createLoanId(ViventorLoanDto dto) {
		def matcher = dto.loanId =~ pattern
		def result = (matcher.find()) ? matcher[0] : super.createLoanId(dto)
	}
}
