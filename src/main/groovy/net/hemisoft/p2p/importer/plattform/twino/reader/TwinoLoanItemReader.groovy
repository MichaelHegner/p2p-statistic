package net.hemisoft.p2p.importer.plattform.twino.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class TwinoLoanItemReader extends _TwinoAbstractItemReader {
	public TwinoLoanItemReader(Resource twinoResource) {
		super(twinoResource)
		this.rowMapper = _TwinoLoanExcelRowMapper.newInstance()
	}
}