package net.hemisoft.p2p.converter.plattform.debitum.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.debitum.dto.DebitumAccountDto
import net.hemisoft.p2p.converter.plattform.processor.AbstractAccountItemProcessor

@Component
public class DebitumAccountItemProcessor extends AbstractAccountItemProcessor<DebitumAccountDto, Account> {
	@Override Account process(DebitumAccountDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.DEBITUM }
}
