package net.hemisoft.p2p.converter.plattform.mintos.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.mintos.dto.MintosAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelItemReader

@Component
class MintosAccountItemReader extends AbstractAccountExcelItemReader<MintosAccountDto> {
	private static final int LINES_TO_SKIP = 1
	
	public MintosAccountItemReader(Resource resource, MintosAccountExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}