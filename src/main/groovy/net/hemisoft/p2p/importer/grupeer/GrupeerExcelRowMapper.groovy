package net.hemisoft.p2p.importer.grupeer

import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet

import net.hemisoft.p2p.importer.commons.ExcelColum

class GrupeerExcelRowMapper implements RowMapper<GrupeerTransactionDto> {
	private static final int COL_ID               = ExcelColum.G.ordinal()
	private static final int COL_INVESTMENT_VALUE = ExcelColum.D.ordinal()

	@Override
	GrupeerTransactionDto mapRow(RowSet rs) throws Exception {
		def dto = GrupeerTransactionDto.newInstance()
		def getCurrentRow = rs.getCurrentRow()
		
		if(getCurrentRow.length > COL_ID) 
			dto.ID = rs.getColumnValue COL_ID
		if(getCurrentRow.length > COL_INVESTMENT_VALUE) 
			dto.investedAmount = rs.getColumnValue COL_INVESTMENT_VALUE
		
		dto
	}

}
