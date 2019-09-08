package net.hemisoft.p2p.converter.converter.plattform.flender.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.plattform.flender.dto.FlenderAccountDto
import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.domain.entity.TransferType
import net.hemisoft.p2p.converter.plattform.processor.AbstractAccountItemProcessor

@Component
public class FlenderAccountItemProcessor extends AbstractAccountItemProcessor<FlenderAccountDto, Account> {
	@Override Account process(FlenderAccountDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.FLENDER }
	
	@Override TransferType createTransferType(String transferType) {
		switch(transferType) {
			case "Balance Top-Up":    TransferType.DEPOSIT;  break
			case "Balance With-Draw": TransferType.WITHDRAW; break
			default: null
		}
	}
}
