package net.hemisoft.p2p.converter.plattform.neofinance.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.neofinance.dto.NeofinanceAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountCsvItemReader

@Component
class NeofinanceAccountItemReader extends AbstractAccountCsvItemReader<NeofinanceAccountDto> {
	private static final int LINES_TO_SKIP = 2
	
	public NeofinanceAccountItemReader(Resource accountResource, NeofinanceAccountCsvRowMapper rowMapper) {
		super(accountResource, rowMapper, LINES_TO_SKIP)
	}
}