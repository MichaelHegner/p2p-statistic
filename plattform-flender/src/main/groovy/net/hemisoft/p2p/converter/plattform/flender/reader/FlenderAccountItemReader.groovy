package net.hemisoft.p2p.converter.plattform.flender.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.flender.dto.FlenderAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountCsvItemReader

@Component
class FlenderAccountItemReader extends AbstractAccountCsvItemReader<FlenderAccountDto> {
	private static final int LINES_TO_SKIP = 1
	
	public FlenderAccountItemReader(Resource accountResource, FlenderAccountCsvLineMapper lineMapper) {
		super(accountResource, lineMapper, LINES_TO_SKIP)
	}
}