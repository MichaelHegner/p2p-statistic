package net.hemisoft.p2p.converter.plattform.viventor.reader

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.plattform.viventor.dto.ViventorLoanDto

@PackageScope
abstract class _ViventorAbstractItemReader extends PoiItemReader<ViventorLoanDto> {
	private static final int LINES_TO_SKIP = 9

	_ViventorAbstractItemReader(Resource viventorResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = viventorResource
	}
}