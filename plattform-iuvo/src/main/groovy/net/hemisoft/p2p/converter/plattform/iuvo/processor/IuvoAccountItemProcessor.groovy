package net.hemisoft.p2p.converter.plattform.iuvo.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.iuvo.dto.IuvoAccountDto
import net.hemisoft.p2p.converter.plattform.processor.AbstractAccountItemProcessor

@Component
public class IuvoAccountItemProcessor extends AbstractAccountItemProcessor<IuvoAccountDto, Account> {
	@Override Account process(IuvoAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.INVESTLY }
}
