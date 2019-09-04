package net.hemisoft.p2p.importer.plattform.mintos

import org.springframework.batch.item.excel.support.rowset.RowSet

import net.hemisoft.p2p.importer.commons.key.ExcelColum
import net.hemisoft.p2p.importer.commons.plattform.AbstractExcelRowMapper
import net.hemisoft.p2p.importer.commons.plattform.AbstractTransactionDto

class MintosExcelRowMapper extends AbstractExcelRowMapper<MintosTransactionDto> {
	private static final int COL_TRANSACTION_ID   = -1 // TODO: No Transaction Id availdable
	private static final int COL_LOAN_ID          = ExcelColum.B.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.R.ordinal()
	private static final int COL_ISSUED           = ExcelColum.C.ordinal()
	
	@Override MintosTransactionDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}
	
	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID         }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractTransactionDto createNewDto() {
		MintosTransactionDto.newInstance()
	}
}
