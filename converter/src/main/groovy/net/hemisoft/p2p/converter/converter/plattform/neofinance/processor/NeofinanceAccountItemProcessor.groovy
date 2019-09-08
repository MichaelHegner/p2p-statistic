package net.hemisoft.p2p.converter.converter.plattform.neofinance.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.converter.converter.plattform.neofinance.dto.NeofinanceAccountDto
import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.domain.entity.TransferType

@Component
public class NeofinanceAccountItemProcessor extends AbstractAccountItemProcessor<NeofinanceAccountDto, Account> {
	@Override
	public Account process(NeofinanceAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.NEOFINANCE }
	
	@Override TransferType createTransferType(String transferType) {
		switch(transferType) {
			case "Money deposit":    TransferType.DEPOSIT;  break
			case "Money withdrawal": TransferType.WITHDRAW; break
			default: null
		}
	}
}
