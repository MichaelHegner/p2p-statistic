package net.hemisoft.p2p.converter.converter.plattform.mintos.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class MintosAccountItemReader extends _MintosAbstractItemReader {
	public MintosAccountItemReader(Resource mintosResource) {
		super(mintosResource)
		this.rowMapper = _MintosAccountExcelRowMapper.newInstance()
	}
}