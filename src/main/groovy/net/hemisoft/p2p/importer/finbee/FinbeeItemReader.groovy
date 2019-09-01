package net.hemisoft.p2p.importer.finbee

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

class FinbeeItemReader extends PoiItemReader<FinbeeTransactionDto> {
	private static final int LINES_TO_SKIP = 1
	
	public FinbeeItemReader(Resource finbeeResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = finbeeResource
		this.rowMapper   = FinbeeExcelRowMapper.newInstance()
	}

}
