package net.hemisoft.p2p.converter.plattform.neofinance.reader

import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.core.io.Resource

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.plattform.neofinance.dto.NeofinanceLoanDto

@PackageScope
abstract class _NeofinanceAbstractItemReader extends FlatFileItemReader<NeofinanceLoanDto> {
	private static final int LINES_TO_SKIP = 2

	_NeofinanceAbstractItemReader(Resource neofinanceResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = neofinanceResource
	}
}