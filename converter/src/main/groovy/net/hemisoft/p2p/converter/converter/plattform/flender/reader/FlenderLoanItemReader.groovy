package net.hemisoft.p2p.converter.converter.plattform.flender.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class FlenderLoanItemReader extends _FlenderAbstractItemReader {
	
	public FlenderLoanItemReader(Resource flenderLoanResource) {
		super(flenderLoanResource)
		this.lineMapper = _FlenderLoanCsvRowMapper.newInstance()
	}

}