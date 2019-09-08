package net.hemisoft.p2p.importer.plattform.investly.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class InvestlyAccountItemReader extends _InvestlyAbstractItemReader {
	InvestlyAccountItemReader(Resource investlyResource) {
		super(investlyResource)
		this.rowMapper = _InvestlyAccountExcelRowMapper.newInstance()
	}
}
