package net.hemisoft.p2p.converter.plattform.bondora.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class BondoraAccountItemReader extends _BondoraAbstractItemReader {
	BondoraAccountItemReader(Resource bondoraResource) {
		super(bondoraResource)
		this.rowMapper = _BondoraAccountExcelRowMapper.newInstance()
	}
}
