package net.hemisoft.p2p.converter.plattform.robocash.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.converter.plattform.robocash.dto.RobocashAccountDto

@Component
public class RobocashAccountItemProcessor extends AbstractAccountItemProcessor<RobocashAccountDto, Account> {
	@Override Account process(RobocashAccountDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.ROBOCASH }
}
