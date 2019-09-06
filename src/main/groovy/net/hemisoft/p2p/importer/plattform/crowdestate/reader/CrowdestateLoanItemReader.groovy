package net.hemisoft.p2p.importer.plattform.crowdestate.reader

import org.springframework.core.io.Resource

class CrowdestateLoanItemReader extends _CrowdestateAbstractItemReader {
	CrowdestateLoanItemReader(Resource crowdestateResource) {
		super(crowdestateResource)
		this.rowMapper = _CrowdestateLoanExcelRowMapper.newInstance()
	}
}
