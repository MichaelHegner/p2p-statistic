package net.hemisoft.p2p.converter.plattform.reader

import org.springframework.batch.item.json.JsonItemReader
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.io.FileSystemResource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.dto.LoanDto

@Component("plattformLoanItemReader")
@ConditionalOnProperty(name="reader.loan.file.type", havingValue="JSON")
class PlattformLoanJsonItemReader extends JsonItemReader<LoanDto> {
	
	PlattformLoanJsonItemReader(
		@Value('${path.loan.input}') String path,
		PlattformLoanJsonObjectReader objectReader
	) {
		super(new FileSystemResource(path), objectReader)
		setName("plattformLoanJsonItemReader")
	}
}
