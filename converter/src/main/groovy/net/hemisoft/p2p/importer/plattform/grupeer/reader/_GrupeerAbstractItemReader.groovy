package net.hemisoft.p2p.importer.plattform.grupeer.reader

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

import groovy.transform.PackageScope
import net.hemisoft.p2p.importer.plattform.grupeer.dto.GrupeerLoanDto

@PackageScope
abstract class _GrupeerAbstractItemReader extends PoiItemReader<GrupeerLoanDto> {
	private static final int LINES_TO_SKIP = 1

	_GrupeerAbstractItemReader(Resource grupeerResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = grupeerResource
	}
}
