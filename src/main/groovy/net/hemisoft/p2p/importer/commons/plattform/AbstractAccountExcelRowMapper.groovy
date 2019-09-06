package net.hemisoft.p2p.importer.commons.plattform

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

import org.apache.commons.lang3.math.NumberUtils
import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.support.rowset.RowSet

import net.hemisoft.p2p.importer.commons.plattform.dto.AbstractAccountDto

public abstract class AbstractAccountExcelRowMapper<T> implements RowMapper<T> {
    abstract int getTransferTypeColumnIndex()
    abstract int getIssuedColumnIndex()
    abstract int getInvestedAmountColumnIndex()
    
    @Override
    AbstractAccountDto mapRow(RowSet rs) throws Exception {
        def dto = createNewDto()
        def currentRow = rs.getCurrentRow()

        if (null == currentRow) return null

        int transferTypeCol = getTransferTypeColumnIndex()
        if(transferTypeCol > -1 && currentRow.length > transferTypeCol) {
            dto.transferType = rs.getColumnValue transferTypeCol
        }

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
            dto.amount = BigDecimal.newInstance(investmentAmountAsString)
        }
        
        dto
    }

    abstract AbstractAccountDto createNewDto()
}
