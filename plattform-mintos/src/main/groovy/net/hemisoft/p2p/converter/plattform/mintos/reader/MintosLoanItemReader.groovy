package net.hemisoft.p2p.converter.plattform.mintos.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.mintos.dto.MintosLoanDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanExcelItemReader

@Component
class MintosLoanItemReader extends AbstractLoanExcelItemReader<MintosLoanDto> {
	private static final int LINES_TO_SKIP = 1
	
	public MintosLoanItemReader(Resource resource, MintosLoanExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}