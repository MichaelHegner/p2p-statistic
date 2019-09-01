package net.hemisoft.p2p.importer.peerberry

import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet

import net.hemisoft.p2p.importer.commons.ExcelColum

class PeerberryExcelRowMapper implements RowMapper<PeerberryTransactionDto> {
	private static final int COL_ID               = ExcelColum.A.ordinal()
	private static final int COL_INVESTMENT_VALUE = ExcelColum.F.ordinal()

	@Override
	PeerberryTransactionDto mapRow(RowSet rs) throws Exception {
		def dto = PeerberryTransactionDto.newInstance()
		def getCurrentRow = rs.getCurrentRow()
		
		if(getCurrentRow.length > COL_ID)
			dto.ID = rs.getColumnValue COL_ID
		if(getCurrentRow.length > COL_INVESTMENT_VALUE)
			dto.investedAmount = rs.getColumnValue COL_INVESTMENT_VALUE
		
		dto
	}

}
