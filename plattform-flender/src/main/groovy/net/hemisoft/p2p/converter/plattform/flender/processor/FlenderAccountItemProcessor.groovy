package net.hemisoft.p2p.converter.plattform.flender.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.flender.dto.FlenderAccountDto
import net.hemisoft.p2p.converter.plattform.processor.AbstractAccountItemProcessor

@Component
public class FlenderAccountItemProcessor extends AbstractAccountItemProcessor<FlenderAccountDto, Account> {
	@Override Account process(FlenderAccountDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.FLENDER }
}
