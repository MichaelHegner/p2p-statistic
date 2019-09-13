package net.hemisoft.p2p.converter.plattform.grupeer.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.grupeer.dto.GrupeerAccountDto
import net.hemisoft.p2p.converter.plattform.processor.AbstractAccountItemProcessor

@Component
public class GrupeerAccountItemProcessor extends AbstractAccountItemProcessor<GrupeerAccountDto, Account> {
	@Override Account process(GrupeerAccountDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.GRUPEER }
}
