package net.hemisoft.p2p.importer.plattform.twino.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.importer.domain.Account
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransferType
import net.hemisoft.p2p.importer.plattform.twino.dto.TwinoAccountDto

@Component
public class TwinoAccountItemProcessor extends AbstractAccountItemProcessor<TwinoAccountDto, Account> {
	@Override Account process(TwinoAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.TWINO }
	
	@Override TransferType createTransferType(String transferType) {
		switch(transferType) {
			case "FUNDING": TransferType.DEPOSIT;  break
			default: null
		}
	}
}
