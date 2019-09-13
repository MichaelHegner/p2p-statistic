package net.hemisoft.p2p.converter.plattform.finbee.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanCsvItemReader

@Component
class FinbeeLoanItemReader extends AbstractLoanCsvItemReader {
	private static final int LINES_TO_SKIP = 1
	
	public FinbeeLoanItemReader(Resource resource, FinbeeLoanCsvLineMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}