package net.hemisoft.p2p.importer.plattform.iuvo.reader

import org.springframework.batch.item.excel.support.rowset.RowSet

import groovy.transform.PackageScope
import net.hemisoft.p2p.importer.commons.key.ExcelColum
import net.hemisoft.p2p.importer.commons.plattform.AbstractLoanExcelRowMapper
import net.hemisoft.p2p.importer.commons.plattform.dto.AbstractLoanDto
import net.hemisoft.p2p.importer.plattform.iuvo.dto.IuvoLoanDto

@PackageScope
class _IuvoLoanExcelRowMapper extends AbstractLoanExcelRowMapper<IuvoLoanDto> {
	private static final int COL_TRANSACTION_ID   = -1 // TODO: No Transaction Id availdable
	private static final int COL_LOAN_ID          = ExcelColum.D.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.F.ordinal()
	private static final int COL_ISSUED           = ExcelColum.A.ordinal()
	
	@Override IuvoLoanDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}
	
	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID         }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractLoanDto createNewDto() {
		IuvoLoanDto.newInstance()
	}
}
