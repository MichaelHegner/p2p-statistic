package net.hemisoft.p2p.converter.converter.plattform.grupeer.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class GrupeerLoanItemReader extends _GrupeerAbstractItemReader {
	public GrupeerLoanItemReader(Resource grupeerResource) {
		super(grupeerResource)
		this.rowMapper = _GrupeerLoanExcelRowMapper.newInstance()
	}
}