package net.hemisoft.p2p.converter.plattform.flender.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.flender.dto.FlenderLoanDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanCsvItemReader

@Component
class FlenderLoanItemReader extends AbstractLoanCsvItemReader<FlenderLoanDto> {
	private static final int LINES_TO_SKIP = 1
	
	public FlenderLoanItemReader(Resource loanResource, FlenderLoanCsvLineMapper lineMapper) {
		super(loanResource, lineMapper, LINES_TO_SKIP)
	}
}