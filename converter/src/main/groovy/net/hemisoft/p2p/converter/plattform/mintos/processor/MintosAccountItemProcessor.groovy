package net.hemisoft.p2p.converter.plattform.mintos.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.converter.domain.Account
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.domain.TransferType
import net.hemisoft.p2p.converter.plattform.mintos.dto.MintosAccountDto

@Component
public class MintosAccountItemProcessor extends AbstractAccountItemProcessor<MintosAccountDto, Account> {
	@Override Account process(MintosAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.MINTOS }
	
	@Override TransferType createTransferType(String transferType) {
		switch(transferType) {
			case "Incoming client payment": TransferType.DEPOSIT;  break
			case "Outgoing client payment": TransferType.WITHDRAW; break
			default: null
		}
	}
}
