package net.hemisoft.p2p.converter.plattform.reader

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

import org.apache.commons.lang3.math.NumberUtils
import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet

import net.hemisoft.p2p.converter.plattform.dto.AbstractLoanDto
import net.hemisoft.p2p.converter.utils.numbers.P2PNumberUtils

public abstract class AbstractLoanExcelRowMapper<T> implements RowMapper<T> {
	abstract int getLoanIdColumnIndex()
	abstract int getIssuedColumnIndex()
	abstract int getInvestedAmountColumnIndex()
	
	@Override
	AbstractLoanDto mapRow(RowSet rs) throws Exception {
		def dto = createNewDto()
		def currentRow = rs.getCurrentRow()

		if (null == currentRow) return null

		int loanIdCol = getLoanIdColumnIndex()
		if(loanIdCol > -1 && currentRow.length > loanIdCol)
			dto.loanId = rs.getColumnValue loanIdCol

		int issuedCol = getIssuedColumnIndex()
		if(issuedCol > -1 && currentRow.length > issuedCol) {
			def issuedFromRowSet = rs.getColumnValue issuedCol
			
			if(NumberUtils.isCreatable(issuedFromRowSet)) {
				def getColumnValue = Long.valueOf(rs.getColumnValue(issuedCol))
				dto.issuedDate = Instant.ofEpochMilli(getColumnValue).atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
			} else {
				dto.issuedDate = issuedFromRowSet
			}
			
		}
		
		int investedAmountCol = getInvestedAmountColumnIndex()
		if(investedAmountCol > -1 && currentRow.length > investedAmountCol) {
			def investmentAmountAsString = rs.getColumnValue(investedAmountCol).replace(",", ".")
			dto.investedAmount = P2PNumberUtils.createDoubleIfPossible investmentAmountAsString
		}
		
		dto
	}

	abstract AbstractLoanDto createNewDto()
}
