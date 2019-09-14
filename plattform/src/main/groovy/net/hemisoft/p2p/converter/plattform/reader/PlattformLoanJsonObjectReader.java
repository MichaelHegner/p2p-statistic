package net.hemisoft.p2p.converter.plattform.reader;

import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.hemisoft.p2p.converter.plattform.dto.LoanDto;

@Component
@ConditionalOnProperty(name="reader.loan.file.type", havingValue="JSON")
public class PlattformLoanJsonObjectReader extends JacksonJsonObjectReader<LoanDto> {

	public PlattformLoanJsonObjectReader(ObjectMapper loanDtoObjectMapper) {
		super(LoanDto.class);
		this.setMapper(loanDtoObjectMapper);
	}

}
