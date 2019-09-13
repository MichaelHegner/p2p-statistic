package net.hemisoft.p2p.converter.plattform.finbee.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.finbee.dto.FinbeeAccountDto
import net.hemisoft.p2p.converter.plattform.processor.AbstractAccountItemProcessor

@Component
public class FinbeeAccountItemProcessor extends AbstractAccountItemProcessor<FinbeeAccountDto, Account> {
	@Override Account process(FinbeeAccountDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.FINBEE }
}
