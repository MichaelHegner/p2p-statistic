package net.hemisoft.p2p.importer.plattform.iuvo.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class IuvoAccountItemReader extends _IuvoAbstractItemReader {
	public IuvoAccountItemReader(Resource iuvoResource) {
		super(iuvoResource)
		this.rowMapper = _IuvoAccountExcelRowMapper.newInstance()
	}
}