package net.hemisoft.p2p.converter.plattform.estateguru.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.converter.domain.Account
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.domain.TransferType
import net.hemisoft.p2p.converter.plattform.estateguru.dto.EstateguruAccountDto

@Component
public class EstateguruAccountItemProcessor extends AbstractAccountItemProcessor<EstateguruAccountDto, Account> {
	@Override Account process(EstateguruAccountDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.ESTATEGURU }
	
	@Override TransferType createTransferType(String transferType) {
		switch(transferType) {
			case "Deposit":    TransferType.DEPOSIT;  break
			case "Withdrawal": TransferType.WITHDRAW; break
			default: null
		}
	}
}
