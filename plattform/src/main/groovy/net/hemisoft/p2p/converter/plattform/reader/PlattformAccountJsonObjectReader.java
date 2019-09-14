package net.hemisoft.p2p.converter.plattform.reader;

import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.hemisoft.p2p.converter.plattform.dto.AccountDto;

@Component
@ConditionalOnProperty(name="reader.account.file.type", havingValue="JSON")
public class PlattformAccountJsonObjectReader extends JacksonJsonObjectReader<AccountDto> {

	public PlattformAccountJsonObjectReader(ObjectMapper accountDtoObjectMapper) {
		super(AccountDto.class);
		this.setMapper(accountDtoObjectMapper);
	}

}
