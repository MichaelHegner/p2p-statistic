package net.hemisoft.p2p.converter.converter.plattform.iuvo.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class IuvoLoanItemReader extends _IuvoAbstractItemReader {
	public IuvoLoanItemReader(Resource iuvoResource) {
		super(iuvoResource)
		this.rowMapper = _IuvoLoanExcelRowMapper.newInstance()
	}
}