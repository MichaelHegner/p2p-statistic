package net.hemisoft.p2p.importer.plattform.grupeer

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

class GrupeerItemReader extends PoiItemReader<GrupeerTransactionDto> {
	private static final int LINES_TO_SKIP = 1
	
	public GrupeerItemReader(Resource grupeerResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = grupeerResource
		this.rowMapper   = GrupeerExcelRowMapper.newInstance()
	}

}
