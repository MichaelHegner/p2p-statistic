package net.hemisoft.p2p.converter.plattform.robocash.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanExcelItemReader
import net.hemisoft.p2p.converter.plattform.robocash.dto.RobocashLoanDto

@Component
class RobocashLoanItemReader extends AbstractLoanExcelItemReader<RobocashLoanDto> {
	private static final int LINES_TO_SKIP = 1
	
	public RobocashLoanItemReader(Resource resource, RobocashLoanExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}
