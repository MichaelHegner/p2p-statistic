package net.hemisoft.p2p.converter.plattform.finbee.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class FinbeeLoanItemReader extends _FinbeeAbstractItemReader {
	public FinbeeLoanItemReader(Resource finbeeResource) {
		super(finbeeResource)
		this.rowMapper   = _FinbeeLoanExcelRowMapper.newInstance()
	}
}