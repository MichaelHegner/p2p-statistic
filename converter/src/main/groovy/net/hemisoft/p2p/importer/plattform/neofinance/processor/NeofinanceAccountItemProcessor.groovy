package net.hemisoft.p2p.importer.plattform.neofinance.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.importer.domain.Account
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransferType
import net.hemisoft.p2p.importer.plattform.neofinance.dto.NeofinanceAccountDto

@Component
public class NeofinanceAccountItemProcessor extends AbstractAccountItemProcessor<NeofinanceAccountDto, Account> {
	@Override
	public Account process(NeofinanceAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.NEOFINANCE }
	
	@Override TransferType createTransferType(String transferType) {
		switch(transferType) {
			case "Money deposit":    TransferType.DEPOSIT;  break
			case "Money withdrawal": TransferType.WITHDRAW; break
			default: null
		}
	}
}
