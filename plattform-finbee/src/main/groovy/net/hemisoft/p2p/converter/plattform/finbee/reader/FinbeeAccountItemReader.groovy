package net.hemisoft.p2p.converter.plattform.finbee.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelItemReader

@Component
class FinbeeAccountItemReader extends AbstractAccountExcelItemReader {
	private static final int LINES_TO_SKIP = 1
	
	FinbeeAccountItemReader(Resource resource, FinbeeAccountExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}