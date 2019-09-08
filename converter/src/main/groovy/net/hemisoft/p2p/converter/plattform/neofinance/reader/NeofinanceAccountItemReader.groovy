package net.hemisoft.p2p.converter.plattform.neofinance.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class NeofinanceAccountItemReader extends _NeofinanceAbstractItemReader {
	public NeofinanceAccountItemReader(Resource neofinanceAccountResource) {
		super(neofinanceAccountResource)
		this.lineMapper = _NeofinanceAccountCsvRowMapper.newInstance()
	}
}