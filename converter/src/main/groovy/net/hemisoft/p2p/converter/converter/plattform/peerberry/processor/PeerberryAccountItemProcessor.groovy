package net.hemisoft.p2p.converter.converter.plattform.peerberry.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.converter.converter.plattform.peerberry.dto.PeerberryAccountDto
import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.domain.entity.TransferType

@Component
public class PeerberryAccountItemProcessor extends AbstractAccountItemProcessor<PeerberryAccountDto, Account> {
	@Override Account process(PeerberryAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.PEERBERRY }
	
	@Override TransferType createTransferType(String transferType) {
		switch(transferType) {
			case "Deposit":    TransferType.DEPOSIT;  break
			case "Withdrawal": TransferType.WITHDRAW; break
			default: null
		}
	}
}
