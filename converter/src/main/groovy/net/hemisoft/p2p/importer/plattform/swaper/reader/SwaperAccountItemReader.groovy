package net.hemisoft.p2p.importer.plattform.swaper.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class SwaperAccountItemReader extends _SwaperAbstractItemReader {
	public SwaperAccountItemReader(Resource swaperResource) {
		super(swaperResource)
		this.rowMapper = _SwaperAccountExcelRowMapper.newInstance()
	}
}