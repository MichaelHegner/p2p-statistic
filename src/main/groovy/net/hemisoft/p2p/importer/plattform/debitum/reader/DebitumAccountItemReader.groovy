package net.hemisoft.p2p.importer.plattform.debitum.reader

import org.springframework.core.io.Resource

class DebitumAccountItemReader extends _DebitumAbstractItemReader {
	DebitumAccountItemReader(Resource debitumResource) {
		super(debitumResource)
		this.rowMapper = _DebitumAccountExcelRowMapper.newInstance()
	}
}
