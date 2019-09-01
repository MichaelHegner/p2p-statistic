package net.hemisoft.p2p.importer.robocash

import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet

import net.hemisoft.p2p.importer.commons.ExcelColum

class RobocashExcelRowMapper implements RowMapper<RobocashTransactionDto> {
	private static final int COL_ID               = ExcelColum.A.ordinal()
	private static final int COL_INVESTMENT_VALUE = ExcelColum.H.ordinal()

	@Override
	RobocashTransactionDto mapRow(RowSet rs) throws Exception {
		def dto = RobocashTransactionDto.newInstance()
		dto.ID             = rs.getColumnValue COL_ID
		dto.investedAmount = rs.getColumnValue COL_INVESTMENT_VALUE
		dto
	}

}
