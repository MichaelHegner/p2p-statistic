package net.hemisoft.p2p.importer.plattform.viventor.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.importer.domain.Account
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransferType
import net.hemisoft.p2p.importer.plattform.viventor.dto.ViventorAccountDto

@Component
public class ViventorAccountItemProcessor extends AbstractAccountItemProcessor<ViventorAccountDto, Account> {
	@Override Account process(ViventorAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.VIVENTOR }
	
	@Override TransferType createTransferType(String transferType) {
		switch(transferType) {
			case "FUNDING": TransferType.DEPOSIT;  break
			default: null
		}
	}
}
