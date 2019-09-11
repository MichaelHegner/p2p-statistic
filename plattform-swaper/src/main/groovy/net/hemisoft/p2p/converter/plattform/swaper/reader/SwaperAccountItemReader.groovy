package net.hemisoft.p2p.converter.plattform.swaper.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelItemReader
import net.hemisoft.p2p.converter.plattform.swaper.dto.SwaperAccountDto

@Component
class SwaperAccountItemReader extends AbstractAccountExcelItemReader<SwaperAccountDto> {
	private static final int LINES_TO_SKIP = 1
	
	public SwaperAccountItemReader(Resource resource, SwaperAccountExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}