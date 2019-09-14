package net.hemisoft.p2p.converter.plattform.reader

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.io.FileSystemResource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.dto.AccountDto

@Component("plattformAccountItemReader")
@ConditionalOnProperty(name="reader.account.file.type", havingValue="EXCEL")
class PlattformAccountExcelItemReader extends _AbstractExcelItemReader<AccountDto> {
	
	PlattformAccountExcelItemReader(
		@Value('${path.account.input}') String path,
		PlattformAccountExcelRowMapper rowMapper,
		@Value('${reader.account.line.skip}') int linesToSkip
	) {
		super(new FileSystemResource(path), rowMapper, linesToSkip)
	}
	
}
