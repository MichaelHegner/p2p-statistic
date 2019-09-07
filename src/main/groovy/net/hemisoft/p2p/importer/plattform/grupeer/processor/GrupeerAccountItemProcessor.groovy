package net.hemisoft.p2p.importer.plattform.grupeer.processor

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.importer.domain.Account
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransferType
import net.hemisoft.p2p.importer.plattform.grupeer.dto.GrupeerAccountDto

public class GrupeerAccountItemProcessor extends AbstractAccountItemProcessor<GrupeerAccountDto, Account> {
	@Override Account process(GrupeerAccountDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.GRUPEER }
	
	@Override TransferType createTransferType(String transferType) {
		switch(transferType) {
			case "Deposit":    TransferType.DEPOSIT;  break
			case "Withdrawal": TransferType.WITHDRAW; break
			default: null
		}
	}
}
