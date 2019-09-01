package net.hemisoft.p2p.importer.plattform.neofinance

import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.core.io.Resource

class NeofinanceItemReader extends FlatFileItemReader<NeofinanceTransactionDto> {
	private static final int LINES_TO_SKIP = 1
	
	public NeofinanceItemReader(Resource neofinanceResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = neofinanceResource
		this.lineMapper  = NeofinanceCsvRowMapper.newInstance()
	}

}
