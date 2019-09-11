package net.hemisoft.p2p.converter.plattform.debitum.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanExcelItemReader

@Component
class DebitumLoanItemReader extends AbstractLoanExcelItemReader {
	private static final int LINES_TO_SKIP = 1
	
	public DebitumLoanItemReader(Resource resource, _DebitumLoanExcelRowMapper rowMapper) {
		super(resource, rowMapper, LINES_TO_SKIP)
	}
}