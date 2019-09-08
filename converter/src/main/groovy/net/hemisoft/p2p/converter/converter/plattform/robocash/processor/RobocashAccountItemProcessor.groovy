package net.hemisoft.p2p.converter.converter.plattform.robocash.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.converter.converter.plattform.robocash.dto.RobocashAccountDto
import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.domain.entity.TransferType

@Component
public class RobocashAccountItemProcessor extends AbstractAccountItemProcessor<RobocashAccountDto, Account> {
	@Override Account process(RobocashAccountDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.ROBOCASH }
	
	@Override TransferType createTransferType(String transferType) {
		switch(transferType) {
			case "Adding funds":      TransferType.DEPOSIT;  break
			case "Withdrawing funds": TransferType.WITHDRAW; break
			default: null
		}
	}
}
