package net.hemisoft.p2p.importer.commons.plattform.processor

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.commons.plattform.dto.AbstractAccountDto
import net.hemisoft.p2p.importer.commons.utils.P2PDateUtils
import net.hemisoft.p2p.importer.commons.utils.P2PNumberUtils
import net.hemisoft.p2p.importer.domain.Account
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransferType

public abstract class AbstractAccountItemProcessor<I extends AbstractAccountDto, O extends Account> implements ItemProcessor<I, O> {

	@Override O process(I dto) throws Exception {
		createPopulated dto
	}
	
	O createPopulated(I dto) {
		def entity            = Account.newInstance()
		entity.amount         = P2PNumberUtils.createDoubleIfPossible  dto.amount
		entity.issued         = P2PDateUtils.createLocalDateIfPossible dto.issuedDate
		entity.plattform      = createPlattform()
		entity.transferType   = createTransferType dto.transferType
		entity
	}
	
	abstract Plattform createPlattform()
	abstract TransferType createTransferType(String transferType)
}
