package net.hemisoft.p2p.converter.plattform.debitum.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class DebitumLoanItemReader extends _DebitumAbstractItemReader {
	public DebitumLoanItemReader(Resource debitumResource) {
		super(debitumResource)
		this.rowMapper = _DebitumLoanExcelRowMapper.newInstance()
	}
}