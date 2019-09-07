package net.hemisoft.p2p.importer.plattform.twino.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class TwinoAccountItemReader extends _TwinoAbstractItemReader {
	public TwinoAccountItemReader(Resource twinoResource) {
		super(twinoResource)
		this.rowMapper = _TwinoAccountExcelRowMapper.newInstance()
	}
}