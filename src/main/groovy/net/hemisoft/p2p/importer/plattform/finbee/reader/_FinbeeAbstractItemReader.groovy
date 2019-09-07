package net.hemisoft.p2p.importer.plattform.finbee.reader

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

import groovy.transform.PackageScope
import net.hemisoft.p2p.importer.plattform.debitum.dto.DebitumLoanDto

@PackageScope
abstract class _FinbeeAbstractItemReader extends PoiItemReader<DebitumLoanDto> {
	private static final int LINES_TO_SKIP = 1

	_FinbeeAbstractItemReader(Resource finbeeResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = finbeeResource
	}
}
