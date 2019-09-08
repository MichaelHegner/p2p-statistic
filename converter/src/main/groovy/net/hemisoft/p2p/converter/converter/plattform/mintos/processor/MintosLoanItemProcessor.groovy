package net.hemisoft.p2p.converter.converter.plattform.mintos.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.plattform.mintos.dto.MintosLoanDto
import net.hemisoft.p2p.converter.domain.entity.Loan
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.processor.AbstractLoanItemProcessor

@Component
public class MintosLoanItemProcessor extends AbstractLoanItemProcessor<MintosLoanDto, Loan> {

	@Override Loan process(MintosLoanDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.MINTOS }
	
	def pattern = ~/\d{7}-\d+$/
	@Override String createLoanId(MintosLoanDto dto) {
		def matcher = dto.loanId =~ pattern
		def result = (matcher.find()) ? matcher[0] : super.createLoanId(dto)
	}
}
