package net.hemisoft.p2p.importer.plattform.estateguru.reader

import org.springframework.core.io.Resource

class EstateguruLoanItemReader extends _EstateguruAbstractItemReader {
	
	public EstateguruLoanItemReader(Resource estateguruResource) {
		super(estateguruResource)
		this.lineMapper = _EstateguruLoanCsvRowMapper.newInstance()
	}

}
