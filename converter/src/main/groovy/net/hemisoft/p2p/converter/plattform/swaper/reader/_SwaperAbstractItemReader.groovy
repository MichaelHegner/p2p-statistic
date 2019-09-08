package net.hemisoft.p2p.converter.plattform.swaper.reader

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.plattform.mintos.dto.MintosLoanDto

@PackageScope
abstract class _SwaperAbstractItemReader extends PoiItemReader<MintosLoanDto> {
	private static final int LINES_TO_SKIP = 1

	_SwaperAbstractItemReader(Resource mintosResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = mintosResource
	}
}