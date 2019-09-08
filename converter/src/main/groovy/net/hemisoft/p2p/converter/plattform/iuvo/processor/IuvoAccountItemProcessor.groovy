package net.hemisoft.p2p.converter.plattform.iuvo.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.converter.domain.Account
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.domain.TransferType
import net.hemisoft.p2p.converter.plattform.iuvo.dto.IuvoAccountDto

@Component
public class IuvoAccountItemProcessor extends AbstractAccountItemProcessor<IuvoAccountDto, Account> {
	@Override Account process(IuvoAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.INVESTLY }
	
	@Override TransferType createTransferType(String transferType) {
		switch(transferType) {
			case "deposit":    TransferType.DEPOSIT;  break
			case "withdrawal": TransferType.WITHDRAW; break
			default: null
		}
	}
}
