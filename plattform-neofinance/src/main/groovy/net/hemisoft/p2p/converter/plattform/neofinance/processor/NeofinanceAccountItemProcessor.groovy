package net.hemisoft.p2p.converter.plattform.neofinance.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.neofinance.dto.NeofinanceAccountDto
import net.hemisoft.p2p.converter.plattform.processor.AbstractAccountItemProcessor

@Component
public class NeofinanceAccountItemProcessor extends AbstractAccountItemProcessor<NeofinanceAccountDto, Account> {
	@Override
	public Account process(NeofinanceAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.NEOFINANCE }
}
