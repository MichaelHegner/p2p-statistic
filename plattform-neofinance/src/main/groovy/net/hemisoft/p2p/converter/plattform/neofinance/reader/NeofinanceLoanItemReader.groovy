package net.hemisoft.p2p.converter.plattform.neofinance.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.neofinance.dto.NeofinanceLoanDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanCsvItemReader

@Component
class NeofinanceLoanItemReader extends AbstractLoanCsvItemReader<NeofinanceLoanDto> {
	private static final int LINES_TO_SKIP = 1
	
	public NeofinanceLoanItemReader(Resource loanResource, NeofinanceLoanCsvRowMapper rowMapper) {
		super(loanResource, rowMapper, LINES_TO_SKIP)
	}
}
