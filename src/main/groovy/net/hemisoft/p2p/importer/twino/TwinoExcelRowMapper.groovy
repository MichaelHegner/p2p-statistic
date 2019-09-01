package net.hemisoft.p2p.importer.twino

import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet

class TwinoExcelRowMapper implements RowMapper<TwinoTransactionDto> {
	private static final int COL_ID = 1
	private static final int COL_INVESTMENT_VALUE = 12

	@Override
	TwinoTransactionDto mapRow(RowSet rs) throws Exception {
		def dto = TwinoTransactionDto.newInstance()
		dto.ID = rs.getColumnValue COL_ID
		dto.investedAmount = rs.getColumnValue COL_INVESTMENT_VALUE
		dto
	}

}
