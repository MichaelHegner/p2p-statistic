package net.hemisoft.p2p.converter.plattform.reader

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.io.FileSystemResource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.dto.LoanDto

@Component("plattformLoanItemReader")
@ConditionalOnProperty(name="reader.loan.file.type", havingValue="CSV")
class PlattformLoanCsvItemReader<T extends LoanDto> extends _AbstractCsvItemReader<T> {
    PlattformLoanCsvItemReader(
        @Value('${path.loan.input}') String path,
        PlattformLoanCsvLineMapper lineMapper,
        @Value('${reader.loan.line.skip}') int linesToSkip
    ) {
        super(new FileSystemResource(path), lineMapper, linesToSkip)
    }
}