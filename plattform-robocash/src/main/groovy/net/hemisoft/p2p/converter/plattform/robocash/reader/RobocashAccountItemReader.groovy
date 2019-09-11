package net.hemisoft.p2p.converter.plattform.robocash.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelItemReader
import net.hemisoft.p2p.converter.plattform.robocash.dto.RobocashAccountDto

@Component
class RobocashAccountItemReader extends AbstractAccountExcelItemReader<RobocashAccountDto> {
	private static final int LINES_TO_SKIP = 1
	
	public RobocashAccountItemReader(Resource resource, RobocashAccountExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}