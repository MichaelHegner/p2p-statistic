package net.hemisoft.p2p.importer.plattform.crowdestate

import org.springframework.batch.item.excel.support.rowset.RowSet

import net.hemisoft.p2p.importer.commons.key.ExcelColum
import net.hemisoft.p2p.importer.commons.plattform.AbstractExcelRowMapper
import net.hemisoft.p2p.importer.commons.plattform.AbstractTransactionDto

class CrowdestateExcelRowMapper extends AbstractExcelRowMapper<CrowdestateTransactionDto> {
	private static final int COL_TRANSACTION_ID   = -1 // TODO: No Transaction Id availdable 
	private static final int COL_LOAN_ID          = -1 // TODO: not really loan id
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.D.ordinal()

	@Override CrowdestateTransactionDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}

	@Override int getTransactionIdColumnIndex()  { COL_TRANSACTION_ID  }
	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID         }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	
	@Override AbstractTransactionDto createNewDto() {
		CrowdestateTransactionDto.newInstance()
	}
}