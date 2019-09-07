package net.hemisoft.p2p.importer.plattform.mintos.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.mintos.dto.MintosLoanDto

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
