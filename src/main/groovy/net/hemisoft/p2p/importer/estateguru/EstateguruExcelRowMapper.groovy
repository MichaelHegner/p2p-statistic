package net.hemisoft.p2p.importer.estateguru

import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet

import net.hemisoft.p2p.importer.commons.ExcelColum

class EstateguruExcelRowMapper implements RowMapper<EstateguruTransactionDto> {
	private static final int COL_ID               = ExcelColum.A.ordinal()
	private static final int COL_INVESTMENT_VALUE = ExcelColum.O.ordinal()

	@Override
	EstateguruTransactionDto mapRow(RowSet rs) throws Exception {
		def dto = EstateguruTransactionDto.newInstance()
		dto.ID = rs.getColumnValue COL_ID
		dto.investedAmount = rs.getColumnValue COL_INVESTMENT_VALUE
		dto
	}

}
