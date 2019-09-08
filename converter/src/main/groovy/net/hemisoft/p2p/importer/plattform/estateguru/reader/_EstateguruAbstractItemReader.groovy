package net.hemisoft.p2p.importer.plattform.estateguru.reader

import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.core.io.Resource

import groovy.transform.PackageScope
import net.hemisoft.p2p.importer.plattform.finbee.dto.FinbeeLoanDto

@PackageScope
abstract class _EstateguruAbstractItemReader extends FlatFileItemReader<FinbeeLoanDto> {
	private static final int LINES_TO_SKIP = 1

	_EstateguruAbstractItemReader(Resource debitumResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = debitumResource
	}
}
