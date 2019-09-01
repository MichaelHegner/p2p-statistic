package net.hemisoft.p2p.importer.plattform.crowdestate

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

class CrowdestateItemReader extends PoiItemReader<CrowdestateTransactionDto> {
	private static final int LINES_TO_SKIP = 1
	
	public CrowdestateItemReader(Resource crowdestateResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = crowdestateResource
		this.rowMapper   = CrowdestateExcelRowMapper.newInstance()
	}

}
