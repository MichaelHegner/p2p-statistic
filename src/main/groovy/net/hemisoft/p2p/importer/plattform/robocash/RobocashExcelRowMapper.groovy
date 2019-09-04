package net.hemisoft.p2p.importer.plattform.robocash

import org.springframework.batch.item.excel.support.rowset.RowSet

import net.hemisoft.p2p.importer.commons.key.ExcelColum
import net.hemisoft.p2p.importer.commons.plattform.AbstractExcelRowMapper
import net.hemisoft.p2p.importer.commons.plattform.AbstractTransactionDto

class RobocashExcelRowMapper extends AbstractExcelRowMapper<RobocashTransactionDto> {
	private static final int COL_TRANSACTION_ID   = ExcelColum.A.ordinal()
	private static final int COL_LOAN_ID          = ExcelColum.E.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.H.ordinal()
	private static final int COL_ISSUED           = ExcelColum.B.ordinal()
	
	@Override
	RobocashTransactionDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}
	
	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID         }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractTransactionDto createNewDto() {
		RobocashTransactionDto.newInstance()
	}
}
