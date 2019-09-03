package net.hemisoft.p2p.importer.plattform.bondora

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

class BondoraItemReader extends PoiItemReader<BondoraTransactionDto> {
	private static final int LINES_TO_SKIP = 3
	
	public BondoraItemReader(Resource bondoraResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = bondoraResource
		this.rowMapper   = BondoraExcelRowMapper.newInstance()
	}

}
