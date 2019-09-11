package net.hemisoft.p2p.converter.plattform.investly.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.investly.dto.InvestlyAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelItemReader

@Component
class InvestlyAccountItemReader extends AbstractAccountExcelItemReader<InvestlyAccountDto> {
	private static final int LINES_TO_SKIP = 1
	
	InvestlyAccountItemReader(Resource resource, InvestlyAccountExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}
