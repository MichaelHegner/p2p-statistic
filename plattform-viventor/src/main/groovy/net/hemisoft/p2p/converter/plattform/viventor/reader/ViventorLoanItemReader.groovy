package net.hemisoft.p2p.converter.plattform.viventor.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanExcelItemReader
import net.hemisoft.p2p.converter.plattform.viventor.dto.ViventorLoanDto

@Component
class ViventorLoanItemReader extends AbstractLoanExcelItemReader<ViventorLoanDto> {
	private static final int LINES_TO_SKIP = 9
	
	public ViventorLoanItemReader(Resource resource, ViventorExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}