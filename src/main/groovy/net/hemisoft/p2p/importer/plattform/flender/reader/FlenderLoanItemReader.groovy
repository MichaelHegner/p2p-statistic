package net.hemisoft.p2p.importer.plattform.flender.reader

import org.springframework.core.io.Resource

class FlenderLoanItemReader extends _FlenderAbstractItemReader {
	
	public FlenderLoanItemReader(Resource flenderLoanResource) {
		super(flenderLoanResource)
		this.lineMapper = _FlenderLoanCsvRowMapper.newInstance()
	}

}