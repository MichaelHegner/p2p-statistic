package net.hemisoft.p2p.converter.plattform.viventor.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.domain.entity.TransferType
import net.hemisoft.p2p.converter.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.converter.plattform.viventor.dto.ViventorAccountDto

@Component
public class ViventorAccountItemProcessor extends AbstractAccountItemProcessor<ViventorAccountDto, Account> {
	@Override Account process(ViventorAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.VIVENTOR }
	
	@Override TransferType createTransferType(String transferType) {
		switch(transferType) {
			case "Funds deposit": TransferType.DEPOSIT;  break
			default: null
		}
	}
}
