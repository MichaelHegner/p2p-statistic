package net.hemisoft.p2p.importer.plattform.estateguru.reader

import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.core.io.Resource

import groovy.transform.PackageScope
import net.hemisoft.p2p.importer.plattform.debitum.dto.DebitumLoanDto

@PackageScope
abstract class _EstateguruAbstractItemReader extends FlatFileItemReader<DebitumLoanDto> {
	private static final int LINES_TO_SKIP = 1

	_EstateguruAbstractItemReader(Resource debitumResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = debitumResource
	}
}
