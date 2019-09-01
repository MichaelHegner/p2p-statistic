package net.hemisoft.p2p.importer.plattform.peerberry

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class PeerberryItemProcessor extends AbstractItemProcessor<PeerberryTransactionDto, TransactionEntity> {

	@Override TransactionEntity process(PeerberryTransactionDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform() { Plattform.PEERBERRY }

}
