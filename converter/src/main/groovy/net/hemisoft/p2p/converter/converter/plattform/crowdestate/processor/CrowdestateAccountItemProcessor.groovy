package net.hemisoft.p2p.converter.converter.plattform.crowdestate.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.converter.converter.plattform.crowdestate.dto.CrowdestateAccountDto
import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.domain.entity.TransferType

@Component
public class CrowdestateAccountItemProcessor extends AbstractAccountItemProcessor<CrowdestateAccountDto, Account> {

	@Override Account process(CrowdestateAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.CROWDESTATE }

	@Override TransferType createTransferType(String transferType) {
		switch(transferType) {
			case "deposit":  TransferType.DEPOSIT;  break
			case "withdraw": TransferType.WITHDRAW; break
			default: null
		}
	}
}
