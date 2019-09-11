package net.hemisoft.p2p.converter.plattform.crowdestate.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanExcelItemReader

@Component
class CrowdestateLoanItemReader extends AbstractLoanExcelItemReader {
	private static final int LINES_TO_SKIP = 1
	
	CrowdestateLoanItemReader(Resource resource, CrowdestateLoanExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}
