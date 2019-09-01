package net.hemisoft.p2p.importer.commons.plattform

import org.springframework.batch.item.file.LineMapper

public abstract class AbstractCsvLineMapper<T> implements LineMapper<T> {
	private static final String SEPARATOR = ","
	
	abstract int getTransactionIdColumnIndex()
	abstract int getLoanIdColumnIndex()
	abstract int getInvestedAmountColumnIndex()
	
	@Override
	AbstractTransactionDto mapLine(String line, int lineNumber) throws Exception {
		def dto = createNewDto()
		def columns = line.replace("\"", "").split(SEPARATOR)
		
		int transactionIdCol = getTransactionIdColumnIndex()
		if(transactionIdCol > -1 && columns.length > transactionIdCol)
			dto.transactionId = columns[transactionIdCol]
			
		int loanIdCol = getLoanIdColumnIndex()
		if(loanIdCol > -1 && columns.length > loanIdCol)
			dto.loanId = columns[loanIdCol]
			
		int investedAmountCol = getInvestedAmountColumnIndex()
		if(investedAmountCol > -1 && columns.length > investedAmountCol) {
			def investmentAmountAsString = columns[investedAmountCol].replace(",", ".")
			dto.investedAmount = BigDecimal.newInstance(investmentAmountAsString)
		}
		
		dto
	}
	
	abstract AbstractTransactionDto createNewDto()
}
