package net.hemisoft.p2p.importer.plattform.crowdestate.processor

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.importer.domain.Account
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransferType
import net.hemisoft.p2p.importer.plattform.crowdestate.dto.CrowdestateAccountDto

public class CrowdestateAccountItemProcessor extends AbstractAccountItemProcessor<CrowdestateAccountDto, Account> {

	@Override Account process(CrowdestateAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.CROWDESTATE }

	@Override TransferType createTransferType(String transferType) {
		switch(transferType) {
			case "deposit":  TransferType.DEPOSIT;  break
			case "withdraw": TransferType.WITHDRAW; break
			default: null
		}
	}
}
