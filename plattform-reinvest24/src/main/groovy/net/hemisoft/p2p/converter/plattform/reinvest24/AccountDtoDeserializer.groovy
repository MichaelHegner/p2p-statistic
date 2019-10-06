package net.hemisoft.p2p.converter.plattform.reinvest24

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer

import net.hemisoft.p2p.converter.plattform.dto.AccountDto

public class AccountDtoDeserializer extends StdDeserializer<AccountDto> {
	private static final long serialVersionUID = 1L

	protected AccountDtoDeserializer(Class<?> vc) {
		super(vc)
	}

	@Override
	public AccountDto deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		JsonNode node = jp.getCodec().readTree(jp)
        AccountDto dto = new AccountDto().with { 
			amount       = node.get("amount").asText()
			transferType = node.get("type").asText()
			issuedDate   = node.get("datetime").asText()
			return it
		}
		
		dto
	}

}