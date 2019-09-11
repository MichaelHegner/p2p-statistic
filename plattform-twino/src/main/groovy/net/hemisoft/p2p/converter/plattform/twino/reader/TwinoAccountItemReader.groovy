package net.hemisoft.p2p.converter.plattform.twino.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelItemReader
import net.hemisoft.p2p.converter.plattform.twino.dto.TwinoAccountDto

@Component
class TwinoAccountItemReader extends AbstractAccountExcelItemReader<TwinoAccountDto> {
	private static final int LINES_TO_SKIP = 3
	
	public TwinoAccountItemReader(Resource resource, TwinoAccountExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}