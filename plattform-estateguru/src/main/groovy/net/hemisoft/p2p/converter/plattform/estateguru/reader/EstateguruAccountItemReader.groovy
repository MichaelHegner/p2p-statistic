package net.hemisoft.p2p.converter.plattform.estateguru.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.estateguru.dto.EstateguruAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountCsvItemReader

@Component
class EstateguruAccountItemReader extends AbstractAccountCsvItemReader<EstateguruAccountDto> {
	private static final LINES_TO_SKIP = 1
	
	public EstateguruAccountItemReader(Resource resource, EstateguruAccountCsvLineMapper lineMapper) {
		super(resource, lineMapper, LINES_TO_SKIP)
	}
}
