package net.hemisoft.p2p.importer.plattform.investly.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class InvestlyLoanItemReader extends _InvestlyAbstractItemReader {
	public InvestlyLoanItemReader(Resource investlyResource) {
		super(investlyResource)
		this.rowMapper = _InvestlyLoanExcelRowMapper.newInstance()
	}
}