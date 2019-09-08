package net.hemisoft.p2p.converter.converter.plattform.mintos.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class MintosLoanItemReader extends _MintosAbstractItemReader {
	public MintosLoanItemReader(Resource mintosResource) {
		super(mintosResource)
		this.rowMapper = _MintosLoanExcelRowMapper.newInstance()
	}
}