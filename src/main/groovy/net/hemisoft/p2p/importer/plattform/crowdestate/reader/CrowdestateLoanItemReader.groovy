package net.hemisoft.p2p.importer.plattform.crowdestate.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class CrowdestateLoanItemReader extends _CrowdestateAbstractItemReader {
	CrowdestateLoanItemReader(Resource crowdestateResource) {
		super(crowdestateResource)
		this.rowMapper = _CrowdestateLoanExcelRowMapper.newInstance()
	}
}
