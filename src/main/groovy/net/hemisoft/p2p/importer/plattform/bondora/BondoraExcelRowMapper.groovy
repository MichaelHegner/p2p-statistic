package net.hemisoft.p2p.importer.plattform.bondora

import org.springframework.batch.item.excel.support.rowset.RowSet

import net.hemisoft.p2p.importer.commons.key.ExcelColum
import net.hemisoft.p2p.importer.commons.plattform.AbstractExcelRowMapper
import net.hemisoft.p2p.importer.commons.plattform.AbstractTransactionDto

class BondoraExcelRowMapper extends AbstractExcelRowMapper<BondoraTransactionDto> {
	private static final int COL_TRANSACTION_ID   = ExcelColum.D.ordinal()
	private static final int COL_LOAN_ID          = ExcelColum.A.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.F.ordinal()

	@Override BondoraTransactionDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}

	@Override int getTransactionIdColumnIndex()  { COL_TRANSACTION_ID  }
	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID         }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	
	@Override AbstractTransactionDto createNewDto() {
		BondoraTransactionDto.newInstance()
	}
}
