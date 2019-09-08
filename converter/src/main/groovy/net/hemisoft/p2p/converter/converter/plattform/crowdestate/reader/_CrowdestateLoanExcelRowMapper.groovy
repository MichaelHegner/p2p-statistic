package net.hemisoft.p2p.converter.converter.plattform.crowdestate.reader

import org.springframework.batch.item.excel.support.rowset.RowSet

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.converter.commons.key.ExcelColum
import net.hemisoft.p2p.converter.converter.commons.plattform.AbstractLoanExcelRowMapper
import net.hemisoft.p2p.converter.converter.commons.plattform.dto.AbstractLoanDto
import net.hemisoft.p2p.converter.converter.plattform.crowdestate.dto.CrowdestateLoanDto

@PackageScope
class _CrowdestateLoanExcelRowMapper extends AbstractLoanExcelRowMapper<CrowdestateLoanDto> {
	private static final int COL_TRANSACTION_ID   = -1 // TODO: No Transaction Id availdable 
	private static final int COL_LOAN_ID          = ExcelColum.H.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.D.ordinal()
	private static final int COL_ISSUED           = ExcelColum.A.ordinal()

	@Override CrowdestateLoanDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}

	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID         }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractLoanDto createNewDto() {
		CrowdestateLoanDto.newInstance()
	}
}
