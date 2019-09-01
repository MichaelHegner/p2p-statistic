package net.hemisoft.p2p.importer.twino

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

class TwinoItemReader extends PoiItemReader<TwinoTransactionDto> {
	private static final int LINES_TO_SKIP = 3
	
	public TwinoItemReader(Resource twinoResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = twinoResource
		this.rowMapper   = TwinoExcelRowMapper.newInstance()
	}

}
