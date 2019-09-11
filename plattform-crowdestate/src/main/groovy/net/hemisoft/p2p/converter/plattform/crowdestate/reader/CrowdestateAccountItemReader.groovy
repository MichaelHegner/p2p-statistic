package net.hemisoft.p2p.converter.plattform.crowdestate.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelItemReader

@Component
class CrowdestateAccountItemReader extends AbstractAccountExcelItemReader {
	private static final int LINES_TO_SKIP = 1
	
	CrowdestateAccountItemReader(Resource resource, CrowdestateAccountExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}
