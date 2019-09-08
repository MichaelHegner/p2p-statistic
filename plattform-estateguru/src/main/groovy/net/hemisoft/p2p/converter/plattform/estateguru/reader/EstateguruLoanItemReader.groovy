package net.hemisoft.p2p.converter.plattform.estateguru.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class EstateguruLoanItemReader extends _EstateguruAbstractItemReader {
	
	public EstateguruLoanItemReader(Resource estateguruResource) {
		super(estateguruResource)
		this.lineMapper = _EstateguruLoanCsvRowMapper.newInstance()
	}

}