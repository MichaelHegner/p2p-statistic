package net.hemisoft.p2p.converter.plattform.viventor.reader

import org.springframework.batch.item.excel.support.rowset.RowSet

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.plattform.dto.AbstractLoanDto
import net.hemisoft.p2p.converter.plattform.key.ExcelColum
import net.hemisoft.p2p.converter.plattform.mapper.AbstractLoanExcelRowMapper
import net.hemisoft.p2p.converter.plattform.viventor.dto.ViventorLoanDto

@PackageScope
class _ViventorExcelRowMapper extends AbstractLoanExcelRowMapper<ViventorLoanDto> {
	private static final int COL_TRANSACTION_ID   = ExcelColum.A.ordinal()
	private static final int COL_LOAN_ID          = ExcelColum.D.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.G.ordinal()
	private static final int COL_ISSUED           = ExcelColum.B.ordinal()
	
	@Override ViventorLoanDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}
	
	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID         }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractLoanDto createNewDto() {
		ViventorLoanDto.newInstance()
	}
}
