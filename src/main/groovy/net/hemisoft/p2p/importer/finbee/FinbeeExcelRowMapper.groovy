package net.hemisoft.p2p.importer.finbee

import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet

import net.hemisoft.p2p.importer.commons.ExcelColum

class FinbeeExcelRowMapper implements RowMapper<FinbeeTransactionDto> {
	private static final int COL_ID               = ExcelColum.A.ordinal()
	private static final int COL_INVESTMENT_VALUE = ExcelColum.F.ordinal()

	@Override
	FinbeeTransactionDto mapRow(RowSet rs) throws Exception {
		def dto = FinbeeTransactionDto.newInstance()
		def getCurrentRow = rs.getCurrentRow()
		
		if(null == getCurrentRow) return null
		
		if(getCurrentRow.length > COL_ID)
			dto.ID = rs.getColumnValue COL_ID
		if(getCurrentRow.length > COL_INVESTMENT_VALUE)
			dto.investedAmount = rs.getColumnValue COL_INVESTMENT_VALUE
		
		dto
	}

}
