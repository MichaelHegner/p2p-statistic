package net.hemisoft.p2p.converter.converter.plattform.viventor.reader

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.plattform.viventor.dto.ViventorLoanDto

@Component
class ViventorLoanItemReader extends PoiItemReader<ViventorLoanDto> {
	private static final int LINES_TO_SKIP = 10
	
	public ViventorLoanItemReader(Resource viventorResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = viventorResource
		this.rowMapper   = _ViventorExcelRowMapper.newInstance()
	}
}