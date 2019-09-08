package net.hemisoft.p2p.converter.plattform.flender.reader

import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.core.io.Resource

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.plattform.flender.dto.FlenderLoanDto

@PackageScope
abstract class _FlenderAbstractItemReader extends FlatFileItemReader<FlenderLoanDto> {
	private static final int LINES_TO_SKIP = 1

	_FlenderAbstractItemReader(Resource flenderResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = flenderResource
	}
}