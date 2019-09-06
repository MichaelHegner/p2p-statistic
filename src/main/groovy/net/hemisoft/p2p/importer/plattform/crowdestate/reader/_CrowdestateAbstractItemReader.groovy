package net.hemisoft.p2p.importer.plattform.crowdestate.reader

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

import groovy.transform.PackageScope
import net.hemisoft.p2p.importer.plattform.crowdestate.dto.CrowdestateLoanDto

@PackageScope
abstract class _CrowdestateAbstractItemReader extends PoiItemReader<CrowdestateLoanDto> {
	private static final int LINES_TO_SKIP = 1

	_CrowdestateAbstractItemReader(Resource crowdestateResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = crowdestateResource
	}
}
