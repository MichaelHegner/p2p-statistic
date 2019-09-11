package net.hemisoft.p2p.converter.plattform.grupeer.reader

import org.springframework.batch.item.excel.support.rowset.RowSet
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.dto.AbstractLoanDto
import net.hemisoft.p2p.converter.plattform.grupeer.dto.GrupeerLoanDto
import net.hemisoft.p2p.converter.plattform.key.ExcelColum
import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanExcelRowMapper

@Component
class GrupeerLoanExcelRowMapper extends AbstractLoanExcelRowMapper<GrupeerLoanDto> {
	private static final int COL_TRANSACTION_ID   = -1 // TODO: No Transaction Id availdable
	private static final int COL_LOAN_ID          = ExcelColum.G.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.D.ordinal()
	private static final int COL_ISSUED           = ExcelColum.A.ordinal()
	
	@Override GrupeerLoanDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}
	
	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID         }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractLoanDto createNewDto() {
		GrupeerLoanDto.newInstance()
	}
}
