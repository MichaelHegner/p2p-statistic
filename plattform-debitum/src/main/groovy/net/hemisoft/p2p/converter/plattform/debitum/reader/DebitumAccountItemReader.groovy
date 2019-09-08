package net.hemisoft.p2p.converter.plattform.debitum.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class DebitumAccountItemReader extends _DebitumAbstractItemReader {
	DebitumAccountItemReader(Resource debitumResource) {
		super(debitumResource)
		this.rowMapper = _DebitumAccountExcelRowMapper.newInstance()
	}
}
