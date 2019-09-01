package net.hemisoft.p2p.importer.viventor

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

class ViventorItemReader extends PoiItemReader<ViventorTransactionDto> {
	private static final int LINES_TO_SKIP = 10
	
	public ViventorItemReader(Resource viventorResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = viventorResource
		this.rowMapper   = ViventorExcelRowMapper.newInstance()
	}

}
