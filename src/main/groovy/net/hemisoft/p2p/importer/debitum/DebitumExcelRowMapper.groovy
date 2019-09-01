package net.hemisoft.p2p.importer.debitum

import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet

import net.hemisoft.p2p.importer.commons.ExcelColum

class DebitumExcelRowMapper implements RowMapper<DebitumTransactionDto> {
	private static final int COL_ID               = ExcelColum.B.ordinal()
	private static final int COL_INVESTMENT_VALUE = ExcelColum.E.ordinal()

	@Override
	DebitumTransactionDto mapRow(RowSet rs) throws Exception {
		def dto = DebitumTransactionDto.newInstance()
		def getCurrentRow = rs.getCurrentRow()
		
		if(null == getCurrentRow) return null
		
		if(getCurrentRow.length > COL_ID)
			dto.ID = rs.getColumnValue COL_ID
		if(getCurrentRow.length > COL_INVESTMENT_VALUE)
			dto.investedAmount = rs.getColumnValue COL_INVESTMENT_VALUE
		
		dto
	}

}
