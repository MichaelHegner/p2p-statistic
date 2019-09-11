package net.hemisoft.p2p.converter.plattform.iuvo.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.iuvo.dto.IuvoAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelItemReader

@Component
class IuvoAccountItemReader extends AbstractAccountExcelItemReader<IuvoAccountDto> {
	private static final int LINES_TO_SKIP = 4
	
	public IuvoAccountItemReader(Resource resource, IuvoAccountExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}