package net.hemisoft.p2p.converter.plattform.twino.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanExcelItemReader
import net.hemisoft.p2p.converter.plattform.twino.dto.TwinoLoanDto

@Component
class TwinoLoanItemReader extends AbstractLoanExcelItemReader<TwinoLoanDto> {
	private static final int LINES_TO_SKIP = 3
	
	public TwinoLoanItemReader(Resource resource, TwinoLoanExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}