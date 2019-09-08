package net.hemisoft.p2p.converter.plattform.mapper

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

import org.apache.commons.lang3.math.NumberUtils
import org.springframework.batch.item.file.LineMapper

import net.hemisoft.p2p.converter.plattform.dto.AbstractLoanDto
import net.hemisoft.p2p.converter.utils.numbers.P2PNumberUtils

public abstract class AbstractLoanCsvLineMapper<T> implements LineMapper<T> {
	private static final String SEPARATOR = ","
	
	abstract int getLoanIdColumnIndex()
	abstract int getIssuedColumnIndex()
	abstract int getInvestedAmountColumnIndex()
	
	@Override
	AbstractLoanDto mapLine(String line, int lineNumber) throws Exception {
		def dto = createNewDto()
		def columns = line.replace("\"", "").split(SEPARATOR)
		
		int loanIdCol = getLoanIdColumnIndex()
		if(loanIdCol > -1 && columns.length > loanIdCol)
			dto.loanId = columns[loanIdCol]
			
		int issuedCol = getIssuedColumnIndex()
		if(issuedCol > -1 && columns.length > issuedCol) {
			def issuedFromRowSet = columns[issuedCol]
				
			if(NumberUtils.isCreatable(issuedFromRowSet)) {
				def getColumnValue = Long.valueOf(columns[issuedCol])
				dto.issuedDate = Instant.ofEpochMilli(getColumnValue).atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
			} else {
				dto.issuedDate = issuedFromRowSet
			}
				
		}
			
		int investedAmountCol = getInvestedAmountColumnIndex()
		if(investedAmountCol > -1 && columns.length > investedAmountCol) {
			def investmentAmountAsString = columns[investedAmountCol].replace(",", ".")
			dto.investedAmount = P2PNumberUtils.createDoubleIfPossible investmentAmountAsString
		}
		
		dto
	}
	
	abstract AbstractLoanDto createNewDto()
}