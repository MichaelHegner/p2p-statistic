package net.hemisoft.p2p.importer.plattform.bondora

import org.springframework.batch.item.excel.support.rowset.RowSet

import net.hemisoft.p2p.importer.commons.key.ExcelColum
import net.hemisoft.p2p.importer.commons.plattform.AbstractLoanExcelRowMapper
import net.hemisoft.p2p.importer.commons.plattform.dto.AbstractLoanDto

class BondoraExcelRowMapper extends AbstractLoanExcelRowMapper<BondoraTransactionDto> {
	private static final int COL_TRANSACTION_ID   = ExcelColum.D.ordinal()
	private static final int COL_LOAN_ID          = ExcelColum.A.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.F.ordinal()
	private static final int COL_ISSUED           = ExcelColum.G.ordinal()

	@Override BondoraTransactionDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}

	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID         }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractLoanDto createNewDto() {
		BondoraTransactionDto.newInstance()
	}
}
