package net.hemisoft.p2p.converter.converter.plattform.bondora.reader

import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.plattform.bondora.dto.BondoraLoanDto

@Component
class BondoraLoanItemReader extends PoiItemReader<BondoraLoanDto> {
	private static final int LINES_TO_SKIP = 3
	
	public BondoraLoanItemReader(Resource bondoraResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = bondoraResource
		this.rowMapper   = BondoraLoanExcelRowMapper.newInstance()
	}

}
