package net.hemisoft.p2p.converter.converter.plattform.swaper.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.converter.converter.plattform.swaper.dto.SwaperAccountDto
import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.domain.entity.TransferType

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
