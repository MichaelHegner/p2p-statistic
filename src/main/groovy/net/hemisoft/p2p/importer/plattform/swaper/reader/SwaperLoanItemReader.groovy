package net.hemisoft.p2p.importer.plattform.swaper.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class SwaperLoanItemReader extends _SwaperAbstractItemReader {
	public SwaperLoanItemReader(Resource swaperResource) {
		super(swaperResource)
		this.rowMapper = _SwaperLoanExcelRowMapper.newInstance()
	}
}