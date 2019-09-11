package net.hemisoft.p2p.converter.plattform.debitum.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelItemReader

@Component
class DebitumAccountItemReader extends AbstractAccountExcelItemReader {
	private static final int LINES_TO_SKIP = 1
	
	DebitumAccountItemReader(Resource resource, DebitumAccountExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}
