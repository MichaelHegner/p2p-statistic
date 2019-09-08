package net.hemisoft.p2p.converter.converter.plattform.flender.reader

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.converter.plattform.flender.dto.FlenderAccountDto
import net.hemisoft.p2p.converter.plattform.key.ExcelColum
import net.hemisoft.p2p.converter.plattform.mapper.AbstractAccountCsvLineMapper

@PackageScope
class _FlenderAccountCsvRowMapper extends AbstractAccountCsvLineMapper<FlenderAccountDto> {
	private static final int COL_TRANSFER_TYPE    = ExcelColum.B.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.C.ordinal()
	private static final int COL_ISSUED           = ExcelColum.D.ordinal()
	
	@Override FlenderAccountDto mapLine(String line, int lineNumber) throws Exception {
		super.mapLine(line, lineNumber)
	}

	@Override int getTransferTypeColumnIndex()   { COL_TRANSFER_TYPE   }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override FlenderAccountDto createNewDto() {
		FlenderAccountDto.newInstance()
	}
}