package net.hemisoft.p2p.importer.plattform.finbee.reader

import org.springframework.core.io.Resource

class FinbeeLoanItemReader extends _FinbeeAbstractItemReader {
	public FinbeeLoanItemReader(Resource finbeeResource) {
		super(finbeeResource)
		this.rowMapper   = _FinbeeLoanExcelRowMapper.newInstance()
	}
}