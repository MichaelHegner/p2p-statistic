package net.hemisoft.p2p.converter.plattform.swaper.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanExcelItemReader
import net.hemisoft.p2p.converter.plattform.swaper.dto.SwaperLoanDto

@Component
class SwaperLoanItemReader extends AbstractLoanExcelItemReader<SwaperLoanDto> {
	private static final int LINES_TO_SKIP = 1
	
	public SwaperLoanItemReader(Resource resource, SwaperLoanExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}