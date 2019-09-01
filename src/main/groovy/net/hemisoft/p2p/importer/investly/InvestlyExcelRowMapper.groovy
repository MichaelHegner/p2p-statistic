package net.hemisoft.p2p.importer.investly

import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet

import net.hemisoft.p2p.importer.commons.ExcelColum

class InvestlyExcelRowMapper implements RowMapper<InvestlyTransactionDto> {
	private static final int COL_ID               = ExcelColum.B.ordinal()
	private static final int COL_INVESTMENT_VALUE = ExcelColum.G.ordinal()

	@Override
	InvestlyTransactionDto mapRow(RowSet rs) throws Exception {
		def dto = InvestlyTransactionDto.newInstance()
		def getCurrentRow = rs.getCurrentRow()
		
		if(getCurrentRow.length > COL_ID)
			dto.ID = rs.getColumnValue COL_ID
		if(getCurrentRow.length > COL_INVESTMENT_VALUE)
			dto.investedAmount = rs.getColumnValue COL_INVESTMENT_VALUE
		
		dto
	}

}
