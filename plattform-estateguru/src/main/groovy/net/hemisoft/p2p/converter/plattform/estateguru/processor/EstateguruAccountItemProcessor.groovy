package net.hemisoft.p2p.converter.plattform.estateguru.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.estateguru.dto.EstateguruAccountDto
import net.hemisoft.p2p.converter.plattform.processor.AbstractAccountItemProcessor

@Component
public class EstateguruAccountItemProcessor extends AbstractAccountItemProcessor<EstateguruAccountDto, Account> {
	@Override Account process(EstateguruAccountDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.ESTATEGURU }
}
