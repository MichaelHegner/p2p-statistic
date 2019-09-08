package net.hemisoft.p2p.converter.plattform.swaper.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.converter.domain.Account
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.domain.TransferType
import net.hemisoft.p2p.converter.plattform.swaper.dto.SwaperAccountDto

@Component
public class SwaperAccountItemProcessor extends AbstractAccountItemProcessor<SwaperAccountDto, Account> {
	@Override Account process(SwaperAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.SWAPER }
	
	@Override TransferType createTransferType(String transferType) {
		switch(transferType) {
			case "FUNDING":     TransferType.DEPOSIT;  break
			case "WITHDRAWING": TransferType.WITHDRAW; break
			default: null
		}
	}
}
