package net.hemisoft.p2p.importer.plattform.bondora.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.importer.domain.Account
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransferType
import net.hemisoft.p2p.importer.plattform.bondora.dto.BondoraAccountDto

@Component
public class BondoraAccountItemProcessor extends AbstractAccountItemProcessor<BondoraAccountDto, Account> {
	@Override Account process(BondoraAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.BONDORA }

	@Override TransferType createTransferType(String transferType) {
		if(transferType.contains("Deposit"))  return TransferType.DEPOSIT
		if(transferType.contains("Withdraw")) return TransferType.WITHDRAW
		                                      return null
	}
}
