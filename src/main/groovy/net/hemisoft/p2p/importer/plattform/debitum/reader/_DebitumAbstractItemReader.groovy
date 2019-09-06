package net.hemisoft.p2p.importer.plattform.debitum.reader

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

import groovy.transform.PackageScope
import net.hemisoft.p2p.importer.plattform.debitum.dto.DebitumLoanDto

@PackageScope
abstract class _DebitumAbstractItemReader extends PoiItemReader<DebitumLoanDto> {
	private static final int LINES_TO_SKIP = 1

	_DebitumAbstractItemReader(Resource debitumResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = debitumResource
	}
}
