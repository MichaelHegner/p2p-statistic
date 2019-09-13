package net.hemisoft.p2p.converter.plattform.twino.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.converter.plattform.twino.dto.TwinoAccountDto

@Component
public class TwinoAccountItemProcessor extends AbstractAccountItemProcessor<TwinoAccountDto, Account> {
	@Override Account process(TwinoAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.TWINO }
}
