package net.hemisoft.p2p.converter.plattform.iuvo.reader

import org.springframework.batch.item.excel.support.rowset.RowSet

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.plattform.dto.AbstractAccountDto
import net.hemisoft.p2p.converter.plattform.iuvo.dto.IuvoAccountDto
import net.hemisoft.p2p.converter.plattform.key.ExcelColum
import net.hemisoft.p2p.converter.plattform.mapper.AbstractAccountExcelRowMapper

@PackageScope
class _IuvoAccountExcelRowMapper extends AbstractAccountExcelRowMapper<IuvoAccountDto> {
	private static final int COL_TRANSFER_TYPE    = ExcelColum.C.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.F.ordinal()
	private static final int COL_ISSUED           = ExcelColum.A.ordinal()

	@Override IuvoAccountDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}

	@Override int getTransferTypeColumnIndex()   { COL_TRANSFER_TYPE   }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractAccountDto createNewDto() {
		IuvoAccountDto.newInstance()
	}
}