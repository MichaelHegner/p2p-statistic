package net.hemisoft.p2p.importer.plattform.swaper

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

class SwaperItemReader extends PoiItemReader<SwaperTransactionDto> {
	private static final int LINES_TO_SKIP = 1
	
	public SwaperItemReader(Resource swaperResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = swaperResource
		this.rowMapper   = SwaperExcelRowMapper.newInstance()
	}

}
