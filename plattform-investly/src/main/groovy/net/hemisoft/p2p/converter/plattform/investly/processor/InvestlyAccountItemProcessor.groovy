package net.hemisoft.p2p.converter.plattform.investly.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.investly.dto.InvestlyAccountDto
import net.hemisoft.p2p.converter.plattform.processor.AbstractAccountItemProcessor

@Component
public class InvestlyAccountItemProcessor extends AbstractAccountItemProcessor<InvestlyAccountDto, Account> {
	@Override Account process(InvestlyAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.INVESTLY }
}
