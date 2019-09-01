package net.hemisoft.p2p.importer.bondora

import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet

class BondoraExcelRowMapper implements RowMapper<BondoraTransactionDto> {
	private static final int COL_ID = 3
	private static final int COL_INVESTMENT_VALUE = 8

	@Override
	BondoraTransactionDto mapRow(RowSet rs) throws Exception {
		def dto = BondoraTransactionDto.newInstance()
		dto.ID = rs.getColumnValue COL_ID
		dto.investedAmount = rs.getColumnValue COL_INVESTMENT_VALUE
		dto
	}

}
