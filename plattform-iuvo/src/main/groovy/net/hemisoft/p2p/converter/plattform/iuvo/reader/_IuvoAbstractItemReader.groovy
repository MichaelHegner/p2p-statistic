package net.hemisoft.p2p.converter.plattform.iuvo.reader

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.plattform.iuvo.dto.IuvoLoanDto

@PackageScope
abstract class _IuvoAbstractItemReader extends PoiItemReader<IuvoLoanDto> {
	private static final int LINES_TO_SKIP = 4

	_IuvoAbstractItemReader(Resource grupeerResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = grupeerResource
	}
}