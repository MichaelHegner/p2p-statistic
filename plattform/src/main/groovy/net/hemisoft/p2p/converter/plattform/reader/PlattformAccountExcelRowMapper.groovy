package net.hemisoft.p2p.converter.plattform.reader

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.math.NumberUtils
import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.dto.AccountDto
import net.hemisoft.p2p.converter.plattform.key.ExcelColum
import net.hemisoft.p2p.converter.utils.numbers.P2PNumberUtils

@Component
@ConditionalOnProperty(name="reader.account.file.type", havingValue="EXCEL")
class PlattformAccountExcelRowMapper implements RowMapper<AccountDto> {
    private Integer readerColumnTransferType
    private Integer readerColumnTransferStatus
    private Integer readerColumnIssued
    private Integer readerColumnInvestedAmount

    @Override
    AccountDto mapRow(RowSet rs) throws Exception {
        def dto = AccountDto.newInstance()
        def currentRow = rs.getCurrentRow()

        if (null == currentRow) return null
        
        if(null != readerColumnTransferType && currentRow.length > readerColumnTransferType) {
            dto.transferType = rs.getColumnValue readerColumnTransferType
        }

        if(null != readerColumnTransferStatus && currentRow.length > readerColumnTransferStatus) {
            dto.transferStatus = rs.getColumnValue readerColumnTransferStatus
        }

        if(null != readerColumnIssued && currentRow.length > readerColumnIssued) {
            def issuedFromRowSet = rs.getColumnValue readerColumnIssued
            
            // TODO: MOVE LOGICC IN P2PDATEUTILS CLASS
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

    
    @Value('${reader.account.column.transfer.type}')
    void setReaderColumnTransferType(String readerColumnTransferType) {
        if(StringUtils.isNoneBlank(readerColumnTransferType))
            this.readerColumnTransferType = ExcelColum.valueOf(readerColumnTransferType).ordinal()
    }
        
    @Value('${reader.account.column.transfer.status:#{null}}')
    void setReaderColumnTransferStatus(String readerColumnTransferStatus) {
        if(StringUtils.isNotBlank(readerColumnTransferStatus))
            this.readerColumnTransferStatus = ExcelColum.valueOf(readerColumnTransferStatus).ordinal()
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
