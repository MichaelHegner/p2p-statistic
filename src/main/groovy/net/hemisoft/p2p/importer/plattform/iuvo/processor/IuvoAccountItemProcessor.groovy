package net.hemisoft.p2p.importer.plattform.iuvo.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.importer.domain.Account
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransferType
import net.hemisoft.p2p.importer.plattform.iuvo.dto.IuvoAccountDto

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
