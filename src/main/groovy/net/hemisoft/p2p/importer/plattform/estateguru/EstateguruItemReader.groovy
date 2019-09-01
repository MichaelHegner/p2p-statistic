package net.hemisoft.p2p.importer.plattform.estateguru

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

class EstateguruItemReader extends PoiItemReader<EstateguruTransactionDto> {
	private static final int LINES_TO_SKIP = 1
	
	public EstateguruItemReader(Resource estateguruResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = estateguruResource
		this.rowMapper   = EstateguruExcelRowMapper.newInstance()
	}

}
