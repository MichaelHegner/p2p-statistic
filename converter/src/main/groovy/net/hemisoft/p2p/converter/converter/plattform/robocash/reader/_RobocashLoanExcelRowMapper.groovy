package net.hemisoft.p2p.converter.converter.plattform.robocash.reader

import org.springframework.batch.item.excel.support.rowset.RowSet

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.converter.commons.key.ExcelColum
import net.hemisoft.p2p.converter.converter.commons.plattform.AbstractLoanExcelRowMapper
import net.hemisoft.p2p.converter.converter.commons.plattform.dto.AbstractLoanDto
import net.hemisoft.p2p.converter.converter.plattform.robocash.dto.RobocashLoanDto

@PackageScope
class _RobocashLoanExcelRowMapper extends AbstractLoanExcelRowMapper<RobocashLoanDto> {
	private static final int COL_TRANSACTION_ID   = ExcelColum.A.ordinal()
	private static final int COL_LOAN_ID          = ExcelColum.E.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.H.ordinal()
	private static final int COL_ISSUED           = ExcelColum.B.ordinal()
	
	@Override
	RobocashLoanDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}
	
	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID         }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractLoanDto createNewDto() {
		RobocashLoanDto.newInstance()
	}
}
