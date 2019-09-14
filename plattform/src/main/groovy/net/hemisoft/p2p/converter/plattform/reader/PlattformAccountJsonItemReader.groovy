package net.hemisoft.p2p.converter.plattform.reader

import org.springframework.batch.item.json.JsonItemReader
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.io.FileSystemResource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.dto.AccountDto

@Component("plattformAccountItemReader")
@ConditionalOnProperty(name="reader.account.file.type", havingValue="JSON")
class PlattformAccountJsonItemReader extends JsonItemReader<AccountDto> {
	
	PlattformAccountJsonItemReader(
		@Value('${path.account.input}') String path,
		PlattformAccountJsonObjectReader objectReader
	) {
		super(new FileSystemResource(path), objectReader)
		setName("plattformAccountJsonItemReader")
	}
}
