package net.hemisoft.p2p.converter.plattform.viventor.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelItemReader
import net.hemisoft.p2p.converter.plattform.viventor.dto.ViventorAccountDto

@Component
class ViventorAccountItemReader extends AbstractAccountExcelItemReader<ViventorAccountDto> {
	private static final int LINES_TO_SKIP = 9
	
	public ViventorAccountItemReader(Resource resource, ViventorAccountExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}