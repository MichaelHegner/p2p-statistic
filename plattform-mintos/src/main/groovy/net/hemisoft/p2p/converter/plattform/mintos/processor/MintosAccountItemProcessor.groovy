package net.hemisoft.p2p.converter.plattform.mintos.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.mintos.dto.MintosAccountDto
import net.hemisoft.p2p.converter.plattform.processor.AbstractAccountItemProcessor

@Component
public class MintosAccountItemProcessor extends AbstractAccountItemProcessor<MintosAccountDto, Account> {
	@Override Account process(MintosAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.MINTOS }
}
