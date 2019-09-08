package net.hemisoft.p2p.converter.plattform.grupeer.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.converter.domain.Account
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.domain.TransferType
import net.hemisoft.p2p.converter.plattform.grupeer.dto.GrupeerAccountDto

@Component
public class GrupeerAccountItemProcessor extends AbstractAccountItemProcessor<GrupeerAccountDto, Account> {
	@Override Account process(GrupeerAccountDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.GRUPEER }
	
	@Override TransferType createTransferType(String transferType) {
		switch(transferType) {
			case "Deposit":    TransferType.DEPOSIT;  break
			case "Withdrawal": TransferType.WITHDRAW; break
			default: null
		}
	}
}
