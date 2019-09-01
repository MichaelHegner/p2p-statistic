package net.hemisoft.p2p.importer.plattform.mintos

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

class MintosItemReader extends PoiItemReader<MintosTransactionDto> {
	private static final int LINES_TO_SKIP = 1
	
	public MintosItemReader(Resource mintosResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = mintosResource
		this.rowMapper   = MintosExcelRowMapper.newInstance()
	}

}
