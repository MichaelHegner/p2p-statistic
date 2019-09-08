package net.hemisoft.p2p.converter.converter.plattform.debitum.reader

import org.springframework.batch.item.excel.support.rowset.RowSet

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.converter.commons.key.ExcelColum
import net.hemisoft.p2p.converter.converter.commons.plattform.AbstractLoanExcelRowMapper
import net.hemisoft.p2p.converter.converter.commons.plattform.dto.AbstractLoanDto
import net.hemisoft.p2p.converter.converter.plattform.debitum.dto.DebitumLoanDto

@PackageScope
class _DebitumLoanExcelRowMapper extends AbstractLoanExcelRowMapper<DebitumLoanDto> {
	private static final int COL_TRANSACTION_ID   = ExcelColum.B.ordinal()
	private static final int COL_LOAN_ID          = ExcelColum.C.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.E.ordinal()
	private static final int COL_ISSUED           = ExcelColum.A.ordinal()

	@Override DebitumLoanDto mapRow(RowSet rs) throws Exception {
		super.mapRow(rs)
	}

	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID         }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractLoanDto createNewDto() {
		DebitumLoanDto.newInstance()
	}
}