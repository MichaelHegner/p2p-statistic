package net.hemisoft.p2p.converter.converter.plattform.bondora.reader

import org.springframework.batch.item.excel.support.rowset.RowSet

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.converter.commons.key.ExcelColum
import net.hemisoft.p2p.converter.converter.commons.plattform.AbstractAccountExcelRowMapper
import net.hemisoft.p2p.converter.converter.plattform.bondora.dto.BondoraAccountDto

@PackageScope
class _BondoraAccountExcelRowMapper extends AbstractAccountExcelRowMapper<BondoraAccountDto> {
	private static final int COL_TRANSFER_TYPE    = ExcelColum.E.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.C.ordinal()
	private static final int COL_ISSUED           = ExcelColum.A.ordinal()

	@Override BondoraAccountDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}

	@Override int getTransferTypeColumnIndex()   { COL_TRANSFER_TYPE   }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override BondoraAccountDto createNewDto() {
		BondoraAccountDto.newInstance()
	}
}