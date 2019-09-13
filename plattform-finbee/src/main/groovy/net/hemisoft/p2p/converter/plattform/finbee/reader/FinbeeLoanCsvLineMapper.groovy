package net.hemisoft.p2p.converter.plattform.finbee.reader

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.dto.AbstractLoanDto
import net.hemisoft.p2p.converter.plattform.finbee.dto.FinbeeLoanDto
import net.hemisoft.p2p.converter.plattform.key.ExcelColum
import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanCsvLineMapper

@Component
class FinbeeLoanCsvLineMapper extends AbstractLoanCsvLineMapper<FinbeeLoanDto> {
	private static final int COL_TRANSACTION_ID   = -1 // TODO: No Transaction Id availdable
	private static final int COL_LOAN_ID          = ExcelColum.C.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.D.ordinal()
	private static final int COL_ISSUED           = ExcelColum.A.ordinal()
	
	@Override FinbeeLoanDto mapLine(String line, int lineNumber) throws Exception {
		super.mapLine line, lineNumber
	}

	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID         }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractLoanDto createNewDto() {
		FinbeeLoanDto.newInstance()
	}
}
