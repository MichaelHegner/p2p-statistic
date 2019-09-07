package net.hemisoft.p2p.importer.plattform.robocash.reader

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

import groovy.transform.PackageScope
import net.hemisoft.p2p.importer.plattform.robocash.dto.RobocashLoanDto

@PackageScope
abstract class _RobocashAbstractItemReader extends PoiItemReader<RobocashLoanDto> {
	private static final int LINES_TO_SKIP = 1

	_RobocashAbstractItemReader(Resource robocashResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = robocashResource
	}
}