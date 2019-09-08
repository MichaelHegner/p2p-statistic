package net.hemisoft.p2p.converter.converter.plattform.twino.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.plattform.twino.dto.TwinoAccountDto
import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.domain.entity.TransferType
import net.hemisoft.p2p.converter.plattform.processor.AbstractAccountItemProcessor

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
