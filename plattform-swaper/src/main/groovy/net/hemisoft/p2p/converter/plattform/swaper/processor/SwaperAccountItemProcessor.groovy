package net.hemisoft.p2p.converter.plattform.swaper.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.converter.plattform.swaper.dto.SwaperAccountDto

@Component
public class SwaperAccountItemProcessor extends AbstractAccountItemProcessor<SwaperAccountDto, Account> {
	@Override Account process(SwaperAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.SWAPER }
}
