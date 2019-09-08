package net.hemisoft.p2p.converter.plattform.twino.reader

import org.springframework.batch.item.excel.support.rowset.RowSet

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.commons.key.ExcelColum
import net.hemisoft.p2p.converter.commons.plattform.AbstractLoanExcelRowMapper
import net.hemisoft.p2p.converter.commons.plattform.dto.AbstractLoanDto
import net.hemisoft.p2p.converter.plattform.twino.dto.TwinoLoanDto

@PackageScope
class _TwinoLoanExcelRowMapper extends AbstractLoanExcelRowMapper<TwinoLoanDto> {
	private static final int COL_TRANSACTION_ID   = ExcelColum.B.ordinal()
	private static final int COL_LOAN_ID          = ExcelColum.E.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.F.ordinal()
	private static final int COL_ISSUED           = ExcelColum.A.ordinal()
	
	@Override TwinoLoanDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}
	
	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID         }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractLoanDto createNewDto() {
		TwinoLoanDto.newInstance()
	}
}
