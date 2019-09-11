package net.hemisoft.p2p.converter.plattform.reader

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

import org.apache.commons.lang3.math.NumberUtils
import org.springframework.batch.item.file.LineMapper
import org.springframework.beans.factory.annotation.Value

import net.hemisoft.p2p.converter.plattform.dto.AbstractAccountDto
import net.hemisoft.p2p.converter.plattform.key.ExcelColum
import net.hemisoft.p2p.converter.utils.numbers.P2PNumberUtils

public abstract class AbstractAccountCsvLineMapper<T extends AbstractAccountDto> implements LineMapper<T> {
	private static final String SEPARATOR = ","

	private Integer readerColumnTransferType
	private Integer readerColumnIssued
	private Integer readerColumnInvestedAmount
	
	
	@Override
	T mapLine(String line, int lineNumber) throws Exception {
		T dto = createNewDto()
		def columns = line.replace("\"", "").split(SEPARATOR)
		
        if(null != readerColumnTransferType && columns.length > readerColumnTransferType) {
            dto.transferType = columns[readerColumnTransferType]
        }
			
		if(null != readerColumnIssued && columns.length > readerColumnIssued) {
			def issuedFromRowSet = columns[readerColumnIssued]
				
			if(NumberUtils.isCreatable(issuedFromRowSet)) {
				def getColumnValue = Long.valueOf(columns[readerColumnIssued])
				dto.issuedDate = Instant.ofEpochMilli(getColumnValue).atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
			} else {
				dto.issuedDate = issuedFromRowSet
			}
				
		}
			
		if(null != readerColumnInvestedAmount && columns.length > readerColumnInvestedAmount) {
			def investmentAmountAsString = columns[readerColumnInvestedAmount].replace(",", ".")
			dto.amount = P2PNumberUtils.createDoubleIfPossible investmentAmountAsString
		}
		
		dto
	}
	
	abstract T createNewDto()
	
	@Value('${reader.account.column.transfer.type}')
	void setReaderColumnTransferType(String readerColumnTransferType) {
		this.readerColumnTransferType = ExcelColum.valueOf(readerColumnTransferType).ordinal()
	}
	
	@Value('${reader.account.column.issued}')
	void setReaderColumnIssued(String readerColumnIssued) {
		this.readerColumnIssued = ExcelColum.valueOf(readerColumnIssued).ordinal()
	}
	
	@Value('${reader.account.column.invested.amount}')
	void setReaderColumnInvestedAmount(String readerColumnInvestedAmount) {
		this.readerColumnInvestedAmount = ExcelColum.valueOf(readerColumnInvestedAmount).ordinal()
	}

}
