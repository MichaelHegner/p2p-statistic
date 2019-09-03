package net.hemisoft.p2p.importer.plattform.flender

import net.hemisoft.p2p.importer.commons.key.ExcelColum
import net.hemisoft.p2p.importer.commons.plattform.AbstractCsvLineMapper
import net.hemisoft.p2p.importer.commons.plattform.AbstractTransactionDto

class FlenderCsvRowMapper extends AbstractCsvLineMapper<FlenderTransactionDto> {
	private static final int COL_TRANSACTION_ID   = -1 // TODO: No Transaction Id availdable
	private static final int COL_LOAN_ID          = ExcelColum.A.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.B.ordinal()

	@Override FlenderTransactionDto mapLine(String line, int lineNumber) throws Exception {
		super.mapLine(line, lineNumber)
	}

	@Override int getTransactionIdColumnIndex()  { COL_TRANSACTION_ID  }
	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID         }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	
	@Override AbstractTransactionDto createNewDto() {
		FlenderTransactionDto.newInstance()
	}
}