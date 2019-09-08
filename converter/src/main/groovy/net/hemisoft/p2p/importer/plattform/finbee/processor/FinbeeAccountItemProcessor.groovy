package net.hemisoft.p2p.importer.plattform.finbee.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.importer.domain.Account
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransferType
import net.hemisoft.p2p.importer.plattform.finbee.dto.FinbeeAccountDto

@Component
public class FinbeeAccountItemProcessor extends AbstractAccountItemProcessor<FinbeeAccountDto, Account> {
	@Override Account process(FinbeeAccountDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.FINBEE }
	
	@Override TransferType createTransferType(String transferType) {
		if (true) return null
		
		// TODO: Currently Finbee plattform down cause of maintenance
		switch(transferType) {
			case "Deposit":    TransferType.DEPOSIT;  break
			case "Withdrawal": TransferType.WITHDRAW; break
			default: null
		}
	}
}
