package net.hemisoft.p2p.converter.plattform.reader

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.io.FileSystemResource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.dto.LoanDto

@Component("plattformLoanItemReader")
@ConditionalOnProperty(name="reader.loan.file.type", havingValue="EXCEL")
class PlattformLoanExcelItemReader extends _AbstractExcelItemReader<LoanDto> {
	PlattformLoanExcelItemReader(
		@Value('${path.loan.input}') String path,
		PlattformLoanExcelRowMapper rowMapper,
		@Value('${reader.loan.line.skip}') int linesToSkip
	) {
		super(new FileSystemResource(path), rowMapper, linesToSkip)
	}
}