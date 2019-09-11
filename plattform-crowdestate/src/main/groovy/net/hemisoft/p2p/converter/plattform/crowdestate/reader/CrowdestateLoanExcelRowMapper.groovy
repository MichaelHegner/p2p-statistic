package net.hemisoft.p2p.converter.plattform.crowdestate.reader

import org.springframework.batch.item.excel.support.rowset.RowSet
import org.springframework.stereotype.Component

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.plattform.crowdestate.dto.CrowdestateLoanDto
import net.hemisoft.p2p.converter.plattform.dto.AbstractLoanDto
import net.hemisoft.p2p.converter.plattform.key.ExcelColum
import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanExcelRowMapper

@Component
class CrowdestateLoanExcelRowMapper extends AbstractLoanExcelRowMapper<CrowdestateLoanDto> {
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
