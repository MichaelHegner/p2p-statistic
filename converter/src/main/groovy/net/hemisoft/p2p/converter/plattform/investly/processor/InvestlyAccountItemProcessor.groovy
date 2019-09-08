package net.hemisoft.p2p.converter.plattform.investly.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.converter.domain.Account
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.domain.TransferType
import net.hemisoft.p2p.converter.plattform.investly.dto.InvestlyAccountDto

@Component
public class InvestlyAccountItemProcessor extends AbstractAccountItemProcessor<InvestlyAccountDto, Account> {
	@Override Account process(InvestlyAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.INVESTLY }
	
	@Override TransferType createTransferType(String transferType) {
		switch(transferType) {
			case "DEPOSIT":    TransferType.DEPOSIT;  break
			case "WITHDRAWAL": TransferType.WITHDRAW; break
			default: null
		}
	}
}
