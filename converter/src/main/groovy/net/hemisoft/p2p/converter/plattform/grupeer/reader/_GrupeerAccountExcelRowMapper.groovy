package net.hemisoft.p2p.converter.plattform.grupeer.reader

import org.springframework.batch.item.excel.support.rowset.RowSet

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.commons.key.ExcelColum
import net.hemisoft.p2p.converter.commons.plattform.AbstractAccountExcelRowMapper
import net.hemisoft.p2p.converter.commons.plattform.dto.AbstractAccountDto
import net.hemisoft.p2p.converter.plattform.grupeer.dto.GrupeerAccountDto

@PackageScope
class _GrupeerAccountExcelRowMapper extends AbstractAccountExcelRowMapper<GrupeerAccountDto> {
	private static final int COL_TRANSFER_TYPE    = ExcelColum.B.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.D.ordinal()
	private static final int COL_ISSUED           = ExcelColum.A.ordinal()

	@Override GrupeerAccountDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}

	@Override int getTransferTypeColumnIndex()   { COL_TRANSFER_TYPE   }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractAccountDto createNewDto() {
		GrupeerAccountDto.newInstance()
	}
}
