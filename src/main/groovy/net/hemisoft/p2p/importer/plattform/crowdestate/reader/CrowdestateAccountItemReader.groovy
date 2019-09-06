package net.hemisoft.p2p.importer.plattform.crowdestate.reader

import org.springframework.core.io.Resource

class CrowdestateAccountItemReader extends _CrowdestateAbstractItemReader {
	CrowdestateAccountItemReader(Resource crowdestateResource) {
		super(crowdestateResource)
		this.rowMapper = _CrowdestateAccountExcelRowMapper.newInstance()
	}
}
