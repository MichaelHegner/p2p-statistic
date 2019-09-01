package net.hemisoft.p2p.importer.swaper

import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet

import net.hemisoft.p2p.importer.commons.ExcelColum

class SwaperExcelRowMapper implements RowMapper<SwaperTransactionDto> {
	private static final int COL_ID               = ExcelColum.E.ordinal()
	private static final int COL_INVESTMENT_VALUE = ExcelColum.C.ordinal()

	@Override
	SwaperTransactionDto mapRow(RowSet rs) throws Exception {
		def dto = SwaperTransactionDto.newInstance()
		def getCurrentRow = rs.getCurrentRow()
		
		if(getCurrentRow.length > COL_ID)
			dto.ID = rs.getColumnValue COL_ID
		if(getCurrentRow.length > COL_INVESTMENT_VALUE)
			dto.investedAmount = rs.getColumnValue COL_INVESTMENT_VALUE
		
		dto
	}

}
