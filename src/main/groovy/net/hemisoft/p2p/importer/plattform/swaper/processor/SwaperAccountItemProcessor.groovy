package net.hemisoft.p2p.importer.plattform.swaper.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.importer.domain.Account
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransferType
import net.hemisoft.p2p.importer.plattform.swaper.dto.SwaperAccountDto

@Component
public class SwaperAccountItemProcessor extends AbstractAccountItemProcessor<SwaperAccountDto, Account> {
	@Override Account process(SwaperAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.SWAPER }
	
	@Override TransferType createTransferType(String transferType) {
		switch(transferType) {
			case "FUNDING":     TransferType.DEPOSIT;  break
			case "WITHDRAWING": TransferType.WITHDRAW; break
			default: null
		}
	}
}
