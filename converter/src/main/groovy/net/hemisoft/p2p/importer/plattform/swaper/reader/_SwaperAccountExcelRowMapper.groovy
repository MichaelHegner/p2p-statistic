package net.hemisoft.p2p.importer.plattform.swaper.reader

import org.springframework.batch.item.excel.support.rowset.RowSet

import groovy.transform.PackageScope
import net.hemisoft.p2p.importer.commons.key.ExcelColum
import net.hemisoft.p2p.importer.commons.plattform.AbstractAccountExcelRowMapper
import net.hemisoft.p2p.importer.commons.plattform.dto.AbstractAccountDto
import net.hemisoft.p2p.importer.plattform.swaper.dto.SwaperAccountDto

@PackageScope
class _SwaperAccountExcelRowMapper extends AbstractAccountExcelRowMapper<SwaperAccountDto> {
	private static final int COL_TRANSFER_TYPE    = ExcelColum.B.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.C.ordinal()
	private static final int COL_ISSUED           = ExcelColum.A.ordinal()

	@Override SwaperAccountDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}

	@Override int getTransferTypeColumnIndex()   { COL_TRANSFER_TYPE   }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractAccountDto createNewDto() {
		SwaperAccountDto.newInstance()
	}
}