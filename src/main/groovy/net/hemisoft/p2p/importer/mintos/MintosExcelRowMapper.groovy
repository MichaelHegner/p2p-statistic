package net.hemisoft.p2p.importer.mintos

import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet

class MintosExcelRowMapper implements RowMapper<MintosTransactionDto> {
	private static final int COL_ID = 1
	private static final int COL_INVESTMENT_VALUE = 17

	@Override
	MintosTransactionDto mapRow(RowSet rs) throws Exception {
		def dto = MintosTransactionDto.newInstance()
		dto.ID = rs.getColumnValue COL_ID
		dto.investedAmount = rs.getColumnValue COL_INVESTMENT_VALUE
		dto
	}

}
