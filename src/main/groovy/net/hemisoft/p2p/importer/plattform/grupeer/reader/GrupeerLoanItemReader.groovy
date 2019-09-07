package net.hemisoft.p2p.importer.plattform.grupeer.reader

import org.springframework.core.io.Resource

class GrupeerLoanItemReader extends _GrupeerAbstractItemReader {
	public GrupeerLoanItemReader(Resource grupeerResource) {
		super(grupeerResource)
		this.rowMapper = _GrupeerLoanExcelRowMapper.newInstance()
	}
}