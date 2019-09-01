package net.hemisoft.p2p.importer.peerberry

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class PeerberryItemProcessor implements ItemProcessor<PeerberryTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(PeerberryTransactionDto dto) throws Exception {
		def entity    = new TransactionEntity()
		entity.id     = dto.ID
		entity.amount = dto.investedAmount
		entity.plattform = Plattform.PEERBERRY
		entity
	}

}
