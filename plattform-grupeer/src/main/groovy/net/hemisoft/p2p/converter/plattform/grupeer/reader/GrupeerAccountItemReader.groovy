package net.hemisoft.p2p.converter.plattform.grupeer.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.grupeer.dto.GrupeerAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelItemReader

@Component
class GrupeerAccountItemReader extends AbstractAccountExcelItemReader<GrupeerAccountDto> {
	private static final int LINES_TO_SKIP = 1
	
	GrupeerAccountItemReader(Resource resource, GrupeerAccountExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}
