package net.hemisoft.p2p.importer.plattform.finbee.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class FinbeeAccountItemReader extends _FinbeeAbstractItemReader {
	FinbeeAccountItemReader(Resource finbeeResource) {
		super(finbeeResource)
		this.rowMapper = _FinbeeAccountExcelRowMapper.newInstance()
	}
}