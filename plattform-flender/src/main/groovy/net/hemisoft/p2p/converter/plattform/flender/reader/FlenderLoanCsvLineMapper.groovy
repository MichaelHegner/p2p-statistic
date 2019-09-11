package net.hemisoft.p2p.converter.plattform.flender.reader

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.dto.AbstractLoanDto
import net.hemisoft.p2p.converter.plattform.flender.dto.FlenderLoanDto
import net.hemisoft.p2p.converter.plattform.key.ExcelColum
import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanCsvLineMapper

@Component
class FlenderLoanCsvLineMapper extends AbstractLoanCsvLineMapper<FlenderLoanDto> {
	private static final int COL_TRANSACTION_ID   = -1 // TODO:
	private static final int COL_LOAN_ID          = ExcelColum.A.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.B.ordinal()
	private static final int COL_ISSUED           = -1 // TODO:
	
	@Override FlenderLoanDto mapLine(String line, int lineNumber) throws Exception {
		super.mapLine(line, lineNumber)
	}

	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID         }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractLoanDto createNewDto() {
		FlenderLoanDto.newInstance()
	}
}
