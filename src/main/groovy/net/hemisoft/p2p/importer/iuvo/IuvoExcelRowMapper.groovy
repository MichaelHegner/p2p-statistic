package net.hemisoft.p2p.importer.iuvo

import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet

import net.hemisoft.p2p.importer.commons.ExcelColum

class IuvoExcelRowMapper implements RowMapper<IuvoTransactionDto> {
	private static final int COL_ID               = ExcelColum.B.ordinal()
	private static final int COL_INVESTMENT_VALUE = ExcelColum.Q.ordinal()

	@Override
	IuvoTransactionDto mapRow(RowSet rs) throws Exception {
		def dto = IuvoTransactionDto.newInstance()
		def getCurrentRow = rs.getCurrentRow()
		
		if(null == getCurrentRow) return null
		
		if(getCurrentRow.length > COL_ID)
			dto.ID = rs.getColumnValue COL_ID
		if(getCurrentRow.length > COL_INVESTMENT_VALUE)
			dto.investedAmount = rs.getColumnValue COL_INVESTMENT_VALUE
		
		dto
	}

}
