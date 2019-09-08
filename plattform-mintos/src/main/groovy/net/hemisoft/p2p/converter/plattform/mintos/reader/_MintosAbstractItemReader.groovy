package net.hemisoft.p2p.converter.plattform.mintos.reader

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.plattform.mintos.dto.MintosLoanDto

@PackageScope
abstract class _MintosAbstractItemReader extends PoiItemReader<MintosLoanDto> {
	private static final int LINES_TO_SKIP = 1

	_MintosAbstractItemReader(Resource mintosResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = mintosResource
	}
}