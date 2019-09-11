package net.hemisoft.p2p.converter.plattform.estateguru.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.estateguru.dto.EstateguruLoanDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanCsvItemReader

@Component
class EstateguruLoanItemReader extends AbstractLoanCsvItemReader<EstateguruLoanDto> {
	private static final LINES_TO_SKIP = 1
	
	public EstateguruLoanItemReader(Resource resource, EstateguruLoanCsvLineMapper lineMapper) {
		super(resource, lineMapper, LINES_TO_SKIP)
	}
}