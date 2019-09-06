package net.hemisoft.p2p.importer.plattform.estateguru.reader

import org.springframework.core.io.Resource

class EstateguruAccountItemReader extends _EstateguruAbstractItemReader {
	
	public EstateguruAccountItemReader(Resource estateguruResource) {
		super(estateguruResource)
		this.lineMapper = _EstateguruAccountCsvRowMapper.newInstance()
	}

}
