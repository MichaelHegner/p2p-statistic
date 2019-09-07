package net.hemisoft.p2p.importer.plattform.estateguru.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.estateguru.dto.EstateguruLoanDto

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
