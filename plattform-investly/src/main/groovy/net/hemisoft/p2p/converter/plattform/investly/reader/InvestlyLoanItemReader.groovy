package net.hemisoft.p2p.converter.plattform.investly.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.investly.dto.InvestlyLoanDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanExcelItemReader

@Component
class InvestlyLoanItemReader extends AbstractLoanExcelItemReader<InvestlyLoanDto> {
	private static final int LINES_TO_SKIP = 1
	
	public InvestlyLoanItemReader(Resource resource, InvestlyLoanExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}