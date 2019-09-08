package net.hemisoft.p2p.importer.plattform.viventor.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.viventor.dto.ViventorLoanDto

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
