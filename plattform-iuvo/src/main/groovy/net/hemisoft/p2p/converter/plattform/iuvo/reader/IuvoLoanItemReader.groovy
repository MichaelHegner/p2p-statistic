package net.hemisoft.p2p.converter.plattform.iuvo.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.iuvo.dto.IuvoLoanDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanExcelItemReader

@Component
class IuvoLoanItemReader extends AbstractLoanExcelItemReader<IuvoLoanDto> {
	private static final int LINES_TO_SKIP = 4
	
	public IuvoLoanItemReader(Resource resource, IuvoLoanExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}