package net.hemisoft.p2p.converter.plattform.grupeer.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class GrupeerAccountItemReader extends _GrupeerAbstractItemReader {
	GrupeerAccountItemReader(Resource grupeerResource) {
		super(grupeerResource)
		this.rowMapper = _GrupeerAccountExcelRowMapper.newInstance()
	}
}
