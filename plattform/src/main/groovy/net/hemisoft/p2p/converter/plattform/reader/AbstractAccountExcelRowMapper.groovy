package net.hemisoft.p2p.converter.plattform.reader

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.math.NumberUtils
import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet
import org.springframework.beans.factory.annotation.Value

import net.hemisoft.p2p.converter.plattform.dto.AbstractAccountDto
import net.hemisoft.p2p.converter.plattform.key.ExcelColum
import net.hemisoft.p2p.converter.utils.numbers.P2PNumberUtils

public abstract class AbstractAccountExcelRowMapper<T extends AbstractAccountDto> implements RowMapper<T> {
    private Integer readerColumnTransferType
	private Integer readerColumnIssued
	private Integer readerColumnInvestedAmount

	
    @Override
    T mapRow(RowSet rs) throws Exception {
        T dto = createNewDto()
        def currentRow = rs.getCurrentRow()

        if (null == currentRow) return null

        if(null != readerColumnTransferType && currentRow.length > readerColumnTransferType) {
            dto.transferType = rs.getColumnValue readerColumnTransferType
        }

        if(null != readerColumnIssued && currentRow.length > readerColumnIssued) {
            def issuedFromRowSet = rs.getColumnValue readerColumnIssued
            
            if(NumberUtils.isCreatable(issuedFromRowSet)) {
                def getColumnValue = NumberUtils.toLong issuedFromRowSet
                dto.issuedDate = Instant.ofEpochMilli(getColumnValue).atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            } else {
                dto.issuedDate = issuedFromRowSet
            }
            
        }
        
        if(null != readerColumnInvestedAmount && currentRow.length > readerColumnInvestedAmount) {
            def investmentAmountAsString = rs.getColumnValue(readerColumnInvestedAmount).replace(",", ".")
            dto.amount = P2PNumberUtils.createDoubleIfPossible investmentAmountAsString
        }
        
        dto
    }

    abstract T createNewDto()
	
	@Value('${reader.account.column.transfer.type}')
	void setReaderColumnTransferType(String readerColumnTransferType) {
		if(StringUtils.isNoneBlank(readerColumnTransferType))
			this.readerColumnTransferType = ExcelColum.valueOf(readerColumnTransferType).ordinal()
	}
	
	@Value('${reader.account.column.issued}')
	void setReaderColumnIssued(String readerColumnIssued) {
		if(StringUtils.isNoneBlank(readerColumnIssued))
			this.readerColumnIssued = ExcelColum.valueOf(readerColumnIssued).ordinal()
	}
	
	@Value('${reader.account.column.invested.amount}')
	void setReaderColumnInvestedAmount(String readerColumnInvestedAmount) {
		if(StringUtils.isNoneBlank(readerColumnInvestedAmount))
			this.readerColumnInvestedAmount = ExcelColum.valueOf(readerColumnInvestedAmount).ordinal()
	}

}