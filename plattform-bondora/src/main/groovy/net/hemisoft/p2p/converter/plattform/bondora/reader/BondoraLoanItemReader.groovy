package net.hemisoft.p2p.converter.plattform.bondora.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.bondora.dto.BondoraLoanDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanExcelItemReader

@Component
class BondoraLoanItemReader extends AbstractLoanExcelItemReader<BondoraLoanDto> {
	private static final int LINES_TO_SKIP = 3
	
	public BondoraLoanItemReader(Resource resource, BondoraLoanExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}
