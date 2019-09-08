package net.hemisoft.p2p.converter.plattform.swaper.reader

import org.springframework.batch.item.excel.support.rowset.RowSet

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.plattform.dto.AbstractLoanDto
import net.hemisoft.p2p.converter.plattform.key.ExcelColum
import net.hemisoft.p2p.converter.plattform.mapper.AbstractLoanExcelRowMapper
import net.hemisoft.p2p.converter.plattform.swaper.dto.SwaperLoanDto

@PackageScope
class _SwaperLoanExcelRowMapper extends AbstractLoanExcelRowMapper<SwaperLoanDto> {
	private static final int COL_TRANSACTION_ID   = -1 // TODO: No Transaction Id availdable
	private static final int COL_LOAN_ID          = ExcelColum.E.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.C.ordinal()
	private static final int COL_ISSUED           = ExcelColum.A.ordinal()
	
	@Override
	SwaperLoanDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}
	
	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID         }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractLoanDto createNewDto() {
		SwaperLoanDto.newInstance()
	}

}
