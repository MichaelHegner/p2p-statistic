package net.hemisoft.p2p.converter.plattform.debitum.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.converter.domain.Account
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.domain.TransferType
import net.hemisoft.p2p.converter.plattform.debitum.dto.DebitumAccountDto

@Component
public class DebitumAccountItemProcessor extends AbstractAccountItemProcessor<DebitumAccountDto, Account> {
	@Override Account process(DebitumAccountDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.DEBITUM }
	
	@Override TransferType createTransferType(String transferType) {
		switch(transferType) {
			case "DEPOSIT":  TransferType.DEPOSIT;  break
			case "WITHDRAW": TransferType.WITHDRAW; break
			default: null
		}
	}
}
