package net.hemisoft.p2p.importer.commons.plattform

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

import org.apache.commons.lang3.math.NumberUtils
import org.springframework.batch.item.file.LineMapper

import net.hemisoft.p2p.importer.commons.plattform.dto.AbstractAccountDto
import net.hemisoft.p2p.importer.commons.utils.P2PNumberUtils

public abstract class AbstractAccountCsvLineMapper<T> implements LineMapper<T> {
	private static final String SEPARATOR = ","
	
    abstract int getTransferTypeColumnIndex()
    abstract int getIssuedColumnIndex()
    abstract int getInvestedAmountColumnIndex()
	
	@Override
	AbstractAccountDto mapLine(String line, int lineNumber) throws Exception {
		def dto = createNewDto()
		def columns = line.replace("\"", "").split(SEPARATOR)
		
		int transferTypeCol = getTransferTypeColumnIndex()
        if(transferTypeCol > -1 && columns.length > transferTypeCol) {
            dto.transferType = columns[transferTypeCol]
        }
			
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
			dto.amount = P2PNumberUtils.createDoubleIfPossible investmentAmountAsString
		}
		
		dto
	}
	
	abstract AbstractAccountDto createNewDto()
}
