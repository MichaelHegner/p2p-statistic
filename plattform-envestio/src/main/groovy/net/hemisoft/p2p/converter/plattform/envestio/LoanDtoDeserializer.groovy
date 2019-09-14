package net.hemisoft.p2p.converter.plattform.envestio

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer

import net.hemisoft.p2p.converter.plattform.dto.LoanDto

public class LoanDtoDeserializer extends StdDeserializer<LoanDto> {
	private static final long serialVersionUID = 1L

	protected LoanDtoDeserializer(Class<?> vc) {
		super(vc)
	}

	@Override
	public LoanDto deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		JsonNode node = jp.getCodec().readTree(jp)
        new LoanDto().with { 
			investedAmount = node.get("operationAmountRaw").numberValue()
			loanId         = node.get("loanNumber").asText()
			issuedDate     = node.get("operationDate").asText()
			return it
		}
	}

}
