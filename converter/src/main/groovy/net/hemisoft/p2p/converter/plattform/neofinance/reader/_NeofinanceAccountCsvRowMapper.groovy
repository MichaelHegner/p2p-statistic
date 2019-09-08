package net.hemisoft.p2p.converter.plattform.neofinance.reader

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.commons.key.ExcelColum
import net.hemisoft.p2p.converter.commons.plattform.AbstractAccountCsvLineMapper
import net.hemisoft.p2p.converter.plattform.neofinance.dto.NeofinanceAccountDto

@PackageScope
class _NeofinanceAccountCsvRowMapper extends AbstractAccountCsvLineMapper<NeofinanceAccountDto> {
	private static final int COL_TRANSFER_TYPE    = ExcelColum.B.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.C.ordinal()
	private static final int COL_ISSUED           = ExcelColum.A.ordinal()
	
	@Override NeofinanceAccountDto mapLine(String line, int lineNumber) throws Exception {
		super.mapLine(line, lineNumber)
	}

	@Override int getTransferTypeColumnIndex()   { COL_TRANSFER_TYPE   }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override NeofinanceAccountDto createNewDto() {
		NeofinanceAccountDto.newInstance()
	}
}