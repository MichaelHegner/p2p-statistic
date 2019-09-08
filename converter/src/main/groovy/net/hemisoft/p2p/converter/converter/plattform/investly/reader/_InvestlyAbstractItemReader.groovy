package net.hemisoft.p2p.converter.converter.plattform.investly.reader

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.converter.plattform.investly.dto.InvestlyLoanDto

@PackageScope
abstract class _InvestlyAbstractItemReader extends PoiItemReader<InvestlyLoanDto> {
	private static final int LINES_TO_SKIP = 1

	_InvestlyAbstractItemReader(Resource grupeerResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = grupeerResource
	}
}
