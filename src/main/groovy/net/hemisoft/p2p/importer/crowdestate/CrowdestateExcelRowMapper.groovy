package net.hemisoft.p2p.importer.crowdestate

import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet

import net.hemisoft.p2p.importer.commons.ExcelColum

class CrowdestateExcelRowMapper implements RowMapper<CrowdestateTransactionDto> {
	private static final int COL_ID               = ExcelColum.H.ordinal()
	private static final int COL_INVESTMENT_VALUE = ExcelColum.D.ordinal()

	@Override
	CrowdestateTransactionDto mapRow(RowSet rs) throws Exception {
		def dto = CrowdestateTransactionDto.newInstance()
		def getCurrentRow = rs.getCurrentRow()
		
		if(getCurrentRow.length > COL_ID)
			dto.ID = rs.getColumnValue COL_ID
		if(getCurrentRow.length > COL_INVESTMENT_VALUE)
			dto.investedAmount = rs.getColumnValue COL_INVESTMENT_VALUE
		
		dto
	}

}
