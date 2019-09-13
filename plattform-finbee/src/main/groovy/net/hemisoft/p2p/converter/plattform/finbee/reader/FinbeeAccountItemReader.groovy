package net.hemisoft.p2p.converter.plattform.finbee.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountCsvItemReader

@Component
class FinbeeAccountItemReader extends AbstractAccountCsvItemReader {
	private static final int LINES_TO_SKIP = 0
	
	FinbeeAccountItemReader(Resource resource, FinbeeAccountCsvLineMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}