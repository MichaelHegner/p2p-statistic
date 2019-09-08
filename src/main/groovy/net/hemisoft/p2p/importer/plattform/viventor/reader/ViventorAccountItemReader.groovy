package net.hemisoft.p2p.importer.plattform.viventor.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class ViventorAccountItemReader extends _ViventorAbstractItemReader {
	public ViventorAccountItemReader(Resource viventorResource) {
		super(viventorResource)
		this.rowMapper = _ViventorAccountExcelRowMapper.newInstance()
	}
}