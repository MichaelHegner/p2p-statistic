package net.hemisoft.p2p.converter.converter.plattform.flender.reader

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.converter.commons.key.ExcelColum
import net.hemisoft.p2p.converter.converter.commons.plattform.AbstractLoanCsvLineMapper
import net.hemisoft.p2p.converter.converter.commons.plattform.dto.AbstractLoanDto
import net.hemisoft.p2p.converter.converter.plattform.flender.dto.FlenderLoanDto

@PackageScope
class _FlenderLoanCsvRowMapper extends AbstractLoanCsvLineMapper<FlenderLoanDto> {
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
