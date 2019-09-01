package net.hemisoft.p2p.importer.viventor

import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet

import net.hemisoft.p2p.importer.commons.ExcelColum

class ViventorExcelRowMapper implements RowMapper<ViventorTransactionDto> {
	private static final int COL_ID               = ExcelColum.A.ordinal()
	private static final int COL_INVESTMENT_VALUE = ExcelColum.G.ordinal()

	@Override
	ViventorTransactionDto mapRow(RowSet rs) throws Exception {
		def dto = ViventorTransactionDto.newInstance()
		def getCurrentRow = rs.getCurrentRow()
		
		if(getCurrentRow.length > COL_ID)
			dto.ID = rs.getColumnValue COL_ID
		if(getCurrentRow.length > COL_INVESTMENT_VALUE)
			dto.investedAmount = rs.getColumnValue COL_INVESTMENT_VALUE
		
		dto
	}

}
