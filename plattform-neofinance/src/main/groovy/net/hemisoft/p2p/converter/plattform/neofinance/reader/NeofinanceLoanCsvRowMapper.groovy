package net.hemisoft.p2p.converter.plattform.neofinance.reader

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.dto.AbstractLoanDto
import net.hemisoft.p2p.converter.plattform.key.ExcelColum
import net.hemisoft.p2p.converter.plattform.neofinance.dto.NeofinanceLoanDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanCsvLineMapper

@Component
class NeofinanceLoanCsvRowMapper extends AbstractLoanCsvLineMapper<NeofinanceLoanDto> {
	private static final int COL_TRANSACTION_ID   = ExcelColum.A.ordinal()
	private static final int COL_LOAN_ID          = ExcelColum.C.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.F.ordinal()
	private static final int COL_ISSUED           = ExcelColum.B.ordinal()
	
	@Override NeofinanceLoanDto mapLine(String line, int lineNumber) throws Exception {
		super.mapLine(line, lineNumber)
	}
	
	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID         }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractLoanDto createNewDto() {
		NeofinanceLoanDto.newInstance()
	}
}
