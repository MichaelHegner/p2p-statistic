package net.hemisoft.p2p.converter.plattform.writer

import java.math.RoundingMode

import org.springframework.batch.item.file.FlatFileHeaderCallback
import org.springframework.batch.item.file.FlatFileItemWriter
import org.springframework.batch.item.file.transform.DelimitedLineAggregator
import org.springframework.batch.item.file.transform.FieldExtractor
import org.springframework.batch.item.file.transform.LineAggregator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.FileSystemResource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.plattform.mapper.PortfolioPerformanceTransferTypeMapper

@Component
public class PortfolioPerformanceCsvItemWriter extends FlatFileItemWriter<Account> {
    private static final String   DELIMITER    = ";"
    private static final String[] COLUMN_NAMES = [ 
        "Datum", "Typ", "Wert", "Buchungswährung", "Steuern", "Stück", "ISIN", "WKN", "Ticker-Symbol", "Wertpapiername", "Notiz" 
    ]
    
    @Autowired
    private PortfolioPerformanceTransferTypeMapper transferTypeMapper
    
    PortfolioPerformanceCsvItemWriter(@Value('${path.portfolio-pro.output}') String path) {
        this.setResource             FileSystemResource.newInstance(path)
        this.setAppendAllowed        true
        this.setShouldDeleteIfExists true
        this.setLineAggregator       createLineAggreator()
        this.setHeaderCallback       createHeaderCallback()
    }
    
    LineAggregator createLineAggreator() {
        new DelimitedLineAggregator<Account>() {
            {
                setDelimiter DELIMITER
                setFieldExtractor(new FieldExtractor<Account>() {
                    Object[] extract(Account item) {
                        def mappedTransferType = transferTypeMapper.map item.transferType
                        def amount = String.format(Locale.GERMAN, "%,.2f", item.amount.setScale(2, RoundingMode.HALF_DOWN))
                        
                        return [
                            item.issued.atStartOfDay(),
                            mappedTransferType,
                            amount,
                            "EUR",
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null
                        ]
                    }
                })
            }
        }
    }
    
    FlatFileHeaderCallback createHeaderCallback() {
       return { it.append(COLUMN_NAMES.join(DELIMITER)) }
    }
   
}
