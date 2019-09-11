package net.hemisoft.p2p.converter.plattform.bondora.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelItemReader

@Component
class BondoraAccountItemReader extends AbstractAccountExcelItemReader {
	private static final int LINES_TO_SKIP = 1
	
	BondoraAccountItemReader(Resource resource, BondoraAccountExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}
