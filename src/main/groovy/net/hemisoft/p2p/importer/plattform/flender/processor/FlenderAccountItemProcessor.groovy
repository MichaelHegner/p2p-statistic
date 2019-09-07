package net.hemisoft.p2p.importer.plattform.flender.processor

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractAccountItemProcessor
import net.hemisoft.p2p.importer.domain.Account
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransferType
import net.hemisoft.p2p.importer.plattform.flender.dto.FlenderAccountDto

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
