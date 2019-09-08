package net.hemisoft.p2p.converter.plattform.finbee.reader

import org.springframework.batch.item.excel.support.rowset.RowSet

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.commons.key.ExcelColum
import net.hemisoft.p2p.converter.commons.plattform.AbstractAccountExcelRowMapper
import net.hemisoft.p2p.converter.commons.plattform.dto.AbstractAccountDto
import net.hemisoft.p2p.converter.plattform.finbee.dto.FinbeeAccountDto

@PackageScope
class _FinbeeAccountExcelRowMapper extends AbstractAccountExcelRowMapper<FinbeeAccountDto> {
	private static final int COL_TRANSFER_TYPE    = -1
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.F.ordinal()
	private static final int COL_ISSUED           = ExcelColum.B.ordinal()

	@Override FinbeeAccountDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}

	@Override int getTransferTypeColumnIndex()   { COL_TRANSFER_TYPE   }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractAccountDto createNewDto() {
		FinbeeAccountDto.newInstance()
	}
}