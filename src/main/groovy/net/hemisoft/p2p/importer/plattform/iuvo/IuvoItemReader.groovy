package net.hemisoft.p2p.importer.plattform.iuvo

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

class IuvoItemReader extends PoiItemReader<IuvoTransactionDto> {
	private static final int LINES_TO_SKIP = 4
	
	public IuvoItemReader(Resource iuvoResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = iuvoResource
		this.rowMapper   = IuvoExcelRowMapper.newInstance()
	}

}
