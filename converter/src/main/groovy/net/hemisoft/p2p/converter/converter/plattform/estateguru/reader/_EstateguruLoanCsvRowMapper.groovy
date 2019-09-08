package net.hemisoft.p2p.converter.converter.plattform.estateguru.reader

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.converter.plattform.estateguru.dto.EstateguruLoanDto
import net.hemisoft.p2p.converter.plattform.dto.AbstractLoanDto
import net.hemisoft.p2p.converter.plattform.key.ExcelColum
import net.hemisoft.p2p.converter.plattform.mapper.AbstractLoanCsvLineMapper

@PackageScope
class _EstateguruLoanCsvRowMapper extends AbstractLoanCsvLineMapper<EstateguruLoanDto> {
	private static final int COL_TRANSACTION_ID   = ExcelColum.A.ordinal()
	private static final int COL_LOAN_ID          = ExcelColum.A.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.H.ordinal()
	private static final int COL_ISSUED           = ExcelColum.B.ordinal()
	
	@Override EstateguruLoanDto mapLine(String line, int lineNumber)throws Exception {
		super.mapLine(line, lineNumber)
	}

	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID        }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractLoanDto createNewDto() {
		EstateguruLoanDto.newInstance()
	}
}
