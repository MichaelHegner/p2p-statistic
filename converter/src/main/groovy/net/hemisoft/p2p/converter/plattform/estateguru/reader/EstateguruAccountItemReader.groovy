package net.hemisoft.p2p.converter.plattform.estateguru.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class EstateguruAccountItemReader extends _EstateguruAbstractItemReader {
	
	public EstateguruAccountItemReader(Resource estateguruResource) {
		super(estateguruResource)
		this.lineMapper = _EstateguruAccountCsvRowMapper.newInstance()
	}

}
