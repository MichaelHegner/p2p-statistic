package net.hemisoft.p2p.importer.bondora

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class BondoraItemProcessor implements ItemProcessor<BondoraTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(BondoraTransactionDto dto) throws Exception {
		def entity    = new TransactionEntity()
		entity.id     = dto.ID
		entity.amount = dto.investedAmount
		entity.plattform = Plattform.BONDORA
		entity
	}

}