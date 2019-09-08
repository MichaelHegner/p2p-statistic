package net.hemisoft.p2p.importer.plattform.neofinance.reader

import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.plattform.neofinance.dto.NeofinanceLoanDto

@Component
class NeofinanceLoanItemReader extends FlatFileItemReader<NeofinanceLoanDto> {
	private static final int LINES_TO_SKIP = 1
	
	public NeofinanceLoanItemReader(Resource neofinanceLoanResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = neofinanceLoanResource
		this.lineMapper  = _NeofinanceLoanCsvRowMapper.newInstance()
	}

}
