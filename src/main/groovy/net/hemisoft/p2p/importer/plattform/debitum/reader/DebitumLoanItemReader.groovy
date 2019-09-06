package net.hemisoft.p2p.importer.plattform.debitum.reader

import org.springframework.core.io.Resource

class DebitumLoanItemReader extends _DebitumAbstractItemReader {
	public DebitumLoanItemReader(Resource debitumResource) {
		super(debitumResource)
		this.rowMapper   = _DebitumLoanExcelRowMapper.newInstance()
	}
}
