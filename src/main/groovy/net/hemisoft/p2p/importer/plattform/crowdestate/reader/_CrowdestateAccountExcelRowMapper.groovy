package net.hemisoft.p2p.importer.plattform.crowdestate.reader

import org.springframework.batch.item.excel.support.rowset.RowSet

import groovy.transform.PackageScope
import net.hemisoft.p2p.importer.commons.key.ExcelColum
import net.hemisoft.p2p.importer.plattform.crowdestate.dto.CrowdestateAccountDto
import net.hemisoft.p2p.importer.commons.plattform.AbstractAccountExcelRowMapper
import net.hemisoft.p2p.importer.commons.plattform.dto.AbstractAccountDto

@PackageScope
class _CrowdestateAccountExcelRowMapper extends AbstractAccountExcelRowMapper<CrowdestateAccountDto> {
	private static final int COL_TRANSFER_TYPE    = ExcelColum.F.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.D.ordinal()
	private static final int COL_ISSUED           = ExcelColum.A.ordinal()

	@Override CrowdestateAccountDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}

	@Override int getTransferTypeColumnIndex()   { COL_TRANSFER_TYPE   }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractAccountDto createNewDto() {
		CrowdestateAccountDto.newInstance()
	}
}
