package net.hemisoft.p2p.importer.robocash

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

class RobocashItemReader extends PoiItemReader<RobocashTransactionDto> {
	private static final int LINES_TO_SKIP = 1
	
	public RobocashItemReader(Resource robocashResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = robocashResource
		this.rowMapper   = RobocashExcelRowMapper.newInstance()
	}

}
