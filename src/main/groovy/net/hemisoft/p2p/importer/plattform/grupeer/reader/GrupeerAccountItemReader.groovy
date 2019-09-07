package net.hemisoft.p2p.importer.plattform.grupeer.reader

import org.springframework.core.io.Resource

class GrupeerAccountItemReader extends _GrupeerAbstractItemReader {
	GrupeerAccountItemReader(Resource grupeerResource) {
		super(grupeerResource)
		this.rowMapper = _GrupeerAccountExcelRowMapper.newInstance()
	}
}
