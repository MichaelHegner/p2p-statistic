package net.hemisoft.p2p.converter.converter.plattform.twino.reader

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.converter.plattform.twino.dto.TwinoLoanDto

@PackageScope
abstract class _TwinoAbstractItemReader extends PoiItemReader<TwinoLoanDto> {
	private static final int LINES_TO_SKIP = 3

	_TwinoAbstractItemReader(Resource twinoResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = twinoResource
	}
}