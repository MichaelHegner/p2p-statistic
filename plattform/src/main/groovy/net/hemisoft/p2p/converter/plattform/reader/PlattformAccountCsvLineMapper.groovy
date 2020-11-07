package net.hemisoft.p2p.converter.plattform.reader

import static org.apache.commons.lang3.StringUtils.trim

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.math.NumberUtils
import org.springframework.batch.item.file.LineMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.dto.AccountDto
import net.hemisoft.p2p.converter.plattform.key.ExcelColum

@Component
@ConditionalOnProperty(name="reader.account.file.type", havingValue="CSV")
class PlattformAccountCsvLineMapper implements LineMapper<AccountDto> {
	@Value('${reader.account.file.separator:,}') 
	private String csvSeparator

	private Integer readerColumnTransferType
	private Integer readerColumnTransferStatus
	private Integer readerColumnIssued
	private Integer readerColumnInvestedAmount
	
	
	@Override
	AccountDto mapLine(String line, int lineNumber) throws Exception {
		AccountDto dto = AccountDto.newInstance()
		String[] columns = line.replace("\"", "").split(csvSeparator)
		
		for(int i = 0; i < columns.length; i++) {
			columns[i] = trim(columns[i])
		}
		
		if(null != readerColumnTransferType && columns.length > readerColumnTransferType) {
			dto.transferType = columns[readerColumnTransferType]
		}

        if(null != readerColumnTransferStatus && columns.length > readerColumnTransferStatus) {
            dto.transferStatus = columns[readerColumnTransferStatus]
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
			dto.amount = columns[readerColumnInvestedAmount].replace(",", ".")
		}
		
		dto
	}
	
	
	@Value('${reader.account.column.transfer.type}')
	void setReaderColumnTransferType(String readerColumnTransferType) {
		this.readerColumnTransferType = ExcelColum.valueOf(readerColumnTransferType).ordinal()
	}

	@Value('${reader.account.column.transfer.status:#{null}}')
	void setReaderColumnTransferStatus(String readerColumnTransferStatus) {
		if(StringUtils.isNotBlank(readerColumnTransferStatus))
			this.readerColumnTransferStatus = ExcelColum.valueOf(readerColumnTransferStatus).ordinal()
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
