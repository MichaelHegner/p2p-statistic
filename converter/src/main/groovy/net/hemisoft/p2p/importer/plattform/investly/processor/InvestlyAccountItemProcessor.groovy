package net.hemisoft.p2p.importer.plattform.investly.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.importer.domain.Account
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransferType
import net.hemisoft.p2p.importer.plattform.investly.dto.InvestlyAccountDto

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
