package net.hemisoft.p2p.importer.plattform.debitum

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

class DebitumItemReader extends PoiItemReader<DebitumTransactionDto> {
	private static final int LINES_TO_SKIP = 1
	
	public DebitumItemReader(Resource debitumResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = debitumResource
		this.rowMapper   = DebitumExcelRowMapper.newInstance()
	}

}
