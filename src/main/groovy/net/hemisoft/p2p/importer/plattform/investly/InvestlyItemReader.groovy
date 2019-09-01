package net.hemisoft.p2p.importer.plattform.investly

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

class InvestlyItemReader extends PoiItemReader<InvestlyTransactionDto> {
	private static final int LINES_TO_SKIP = 1
	
	public InvestlyItemReader(Resource investlyResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = investlyResource
		this.rowMapper   = InvestlyExcelRowMapper.newInstance()
	}

}
