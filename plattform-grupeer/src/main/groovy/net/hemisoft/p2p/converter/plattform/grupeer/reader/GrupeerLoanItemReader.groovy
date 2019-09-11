package net.hemisoft.p2p.converter.plattform.grupeer.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.grupeer.dto.GrupeerLoanDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanExcelItemReader

@Component
class GrupeerLoanItemReader extends AbstractLoanExcelItemReader<GrupeerLoanDto> {
	private static final int LINES_TO_SKIP = 1
	
	public GrupeerLoanItemReader(Resource resource, GrupeerLoanExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}