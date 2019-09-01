package net.hemisoft.p2p.importer.plattform.peerberry

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

class PeerberryItemReader extends PoiItemReader<PeerberryTransactionDto> {
	private static final int LINES_TO_SKIP = 1
	
	public PeerberryItemReader(Resource peerberryResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = peerberryResource
		this.rowMapper   = PeerberryExcelRowMapper.newInstance()
	}

}
