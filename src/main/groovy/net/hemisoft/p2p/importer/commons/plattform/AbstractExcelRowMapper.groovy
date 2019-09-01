package net.hemisoft.p2p.importer.commons.plattform

import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet

public abstract class AbstractExcelRowMapper<T> implements RowMapper<T> {
	abstract int getTransactionIdColumnIndex()
	abstract int getLoanIdColumnIndex()
	abstract int getInvestedAmountColumnIndex()

	@Override
	AbstractTransactionDto mapRow(RowSet rs) throws Exception {
		def dto = createNewDto()
		def currentRow = rs.getCurrentRow()

		if (null == currentRow) return null

		int transactionIdCol = getTransactionIdColumnIndex()
		if(transactionIdCol > -1 && currentRow.length > transactionIdCol)
			dto.transactionId = rs.getColumnValue transactionIdCol

		int loanIdCol = getLoanIdColumnIndex()
		if(loanIdCol > -1 && currentRow.length > loanIdCol)
			dto.loanId = rs.getColumnValue loanIdCol

		int investedAmountCol = getInvestedAmountColumnIndex()
		if(investedAmountCol > -1 && currentRow.length > investedAmountCol) {
			def investmentAmountAsString = rs.getColumnValue(investedAmountCol).replace(",", ".")
			dto.investedAmount = BigDecimal.newInstance(investmentAmountAsString)
		}
		dto
	}

	abstract AbstractTransactionDto createNewDto()
}
