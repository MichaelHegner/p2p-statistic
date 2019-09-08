package net.hemisoft.p2p.converter.plattform.bondora.reader

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.plattform.bondora.dto.BondoraLoanDto

@PackageScope
abstract class _BondoraAbstractItemReader extends PoiItemReader<BondoraLoanDto> {
	private static final int LINES_TO_SKIP = 1

	_BondoraAbstractItemReader(Resource crowdestateResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = crowdestateResource
	}
}
