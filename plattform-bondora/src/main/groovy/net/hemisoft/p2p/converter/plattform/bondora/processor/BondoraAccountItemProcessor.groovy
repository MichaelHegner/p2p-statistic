package net.hemisoft.p2p.converter.plattform.bondora.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.bondora.dto.BondoraAccountDto
import net.hemisoft.p2p.converter.plattform.processor.AbstractAccountItemProcessor

@Component
public class BondoraAccountItemProcessor extends AbstractAccountItemProcessor<BondoraAccountDto, Account> {
	@Override Account process(BondoraAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.BONDORA }
}
