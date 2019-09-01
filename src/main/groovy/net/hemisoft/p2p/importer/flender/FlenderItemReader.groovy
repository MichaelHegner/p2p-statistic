package net.hemisoft.p2p.importer.flender

import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.core.io.Resource

class FlenderItemReader extends FlatFileItemReader<FlenderTransactionDto> {
	private static final int LINES_TO_SKIP = 1
	
	public FlenderItemReader(Resource flenderResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = flenderResource
		this.lineMapper  = FlenderCsvRowMapper.newInstance()
	}

}
