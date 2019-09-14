package net.hemisoft.p2p.converter.plattform.reader

import static org.apache.commons.lang3.StringUtils.isNoneBlank

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

import org.apache.commons.lang3.math.NumberUtils
import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.dto.LoanDto
import net.hemisoft.p2p.converter.plattform.key.ExcelColum
import net.hemisoft.p2p.converter.utils.numbers.P2PNumberUtils

@Component
@ConditionalOnProperty(name="reader.loan.file.type", havingValue="EXCEL")
class PlattformLoanExcelRowMapper implements RowMapper<LoanDto> {
	private Integer readerColumnTransactionId
	private Integer readerColumnLoanId
	private Integer readerColumnIssued
	private Integer readerColumnInvestedAmount
	
	
	@Override
	LoanDto mapRow(RowSet rs) throws Exception {
		def dto = LoanDto.newInstance()
		def currentRow = rs.getCurrentRow()

		if (null == currentRow) return null

		if(readerColumnLoanId > -1 && currentRow.length > readerColumnLoanId)
			dto.loanId = rs.getColumnValue readerColumnLoanId

		if(readerColumnIssued > -1 && currentRow.length > readerColumnIssued) {
			def issuedFromRowSet = rs.getColumnValue readerColumnIssued
			
			if(NumberUtils.isCreatable(issuedFromRowSet)) {
				def getColumnValue = Long.valueOf(rs.getColumnValue(readerColumnIssued))
				dto.issuedDate = Instant.ofEpochMilli(getColumnValue).atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
			} else {
				dto.issuedDate = issuedFromRowSet
			}
			
		}
		
		if(readerColumnInvestedAmount > -1 && currentRow.length > readerColumnInvestedAmount) {
			def investmentAmountAsString = rs.getColumnValue(readerColumnInvestedAmount).replace(",", ".")
			dto.investedAmount = P2PNumberUtils.createDoubleIfPossible investmentAmountAsString
		}
		
		dto
	}
	
	
	@Value('${reader.loan.column.transaction.id}')
	void setReaderColumnTransactionId(String readerColumnTransactionId) {
		if(isNoneBlank(readerColumnTransactionId))
			this.readerColumnTransactionId = ExcelColum.valueOf(readerColumnTransactionId).ordinal()
	}
	
	@Value('${reader.loan.column.laon.id}')
	void setReaderColumnLoanId(String readerColumnLoanId) {
		if(isNoneBlank(readerColumnLoanId))
			this.readerColumnLoanId = ExcelColum.valueOf(readerColumnLoanId).ordinal()
	}
	
	@Value('${reader.loan.column.issued}')
	void setReaderColumnIssued(String readerColumnIssued) {
		if(isNoneBlank(readerColumnIssued))
			this.readerColumnIssued = ExcelColum.valueOf(readerColumnIssued).ordinal()
	}
	
	@Value('${reader.loan.column.invested.amount}')
	void setReaderColumnInvestedAmount(String readerColumnInvestedAmount) {
		if(isNoneBlank(readerColumnInvestedAmount))
			this.readerColumnInvestedAmount = ExcelColum.valueOf(readerColumnInvestedAmount).ordinal()
	}

}
