package net.hemisoft.p2p.importer.plattform.twino.reader

import org.springframework.batch.item.excel.support.rowset.RowSet

import groovy.transform.PackageScope
import net.hemisoft.p2p.importer.commons.key.ExcelColum
import net.hemisoft.p2p.importer.commons.plattform.AbstractAccountExcelRowMapper
import net.hemisoft.p2p.importer.commons.plattform.dto.AbstractAccountDto
import net.hemisoft.p2p.importer.plattform.twino.dto.TwinoAccountDto

@PackageScope
class _TwinoAccountExcelRowMapper extends AbstractAccountExcelRowMapper<TwinoAccountDto> {
	private static final int COL_TRANSFER_TYPE    = ExcelColum.C.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.F.ordinal()
	private static final int COL_ISSUED           = ExcelColum.A.ordinal()

	@Override TwinoAccountDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}

	@Override int getTransferTypeColumnIndex()   { COL_TRANSFER_TYPE   }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractAccountDto createNewDto() {
		TwinoAccountDto.newInstance()
	}
}