package net.hemisoft.p2p.converter.converter.plattform.robocash.reader

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.plattform.robocash.dto.RobocashLoanDto

@Component
class RobocashLoanItemReader extends PoiItemReader<RobocashLoanDto> {
	private static final int LINES_TO_SKIP = 1
	
	public RobocashLoanItemReader(Resource robocashResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = robocashResource
		this.rowMapper   = _RobocashLoanExcelRowMapper.newInstance()
	}

}
