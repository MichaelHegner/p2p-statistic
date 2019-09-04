package net.hemisoft.p2p.importer.plattform.neofinance

import net.hemisoft.p2p.importer.commons.key.ExcelColum
import net.hemisoft.p2p.importer.commons.plattform.AbstractCsvLineMapper
import net.hemisoft.p2p.importer.commons.plattform.AbstractTransactionDto

class NeofinanceCsvRowMapper extends AbstractCsvLineMapper<NeofinanceTransactionDto> {
	private static final int COL_TRANSACTION_ID   = ExcelColum.A.ordinal()
	private static final int COL_LOAN_ID          = ExcelColum.C.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.F.ordinal()
	private static final int COL_ISSUED           = ExcelColum.B.ordinal()
	
	@Override NeofinanceTransactionDto mapLine(String line, int lineNumber) throws Exception {
		super.mapLine(line, lineNumber)
	}
	
	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID         }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractTransactionDto createNewDto() {
		NeofinanceTransactionDto.newInstance()
	}
}
