package net.hemisoft.p2p.converter.converter.plattform.estateguru.reader

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.converter.commons.key.ExcelColum
import net.hemisoft.p2p.converter.converter.commons.plattform.AbstractAccountCsvLineMapper
import net.hemisoft.p2p.converter.converter.plattform.estateguru.dto.EstateguruAccountDto

@PackageScope
class _EstateguruAccountCsvRowMapper extends AbstractAccountCsvLineMapper<EstateguruAccountDto> {
	private static final int COL_TRANSFER_TYPE    = ExcelColum.D.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.H.ordinal()
	private static final int COL_ISSUED           = ExcelColum.B.ordinal()
	
	@Override EstateguruAccountDto mapLine(String line, int lineNumber) throws Exception {
		super.mapLine(line, lineNumber)
	}

	@Override int getTransferTypeColumnIndex()   { COL_TRANSFER_TYPE   }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override EstateguruAccountDto createNewDto() {
		EstateguruAccountDto.newInstance()
	}
}
