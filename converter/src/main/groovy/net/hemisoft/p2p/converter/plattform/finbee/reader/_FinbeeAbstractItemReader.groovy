package net.hemisoft.p2p.converter.plattform.finbee.reader

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.plattform.finbee.dto.FinbeeLoanDto

@PackageScope
abstract class _FinbeeAbstractItemReader extends PoiItemReader<FinbeeLoanDto> {
	private static final int LINES_TO_SKIP = 1

	_FinbeeAbstractItemReader(Resource finbeeResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = finbeeResource
	}
}
