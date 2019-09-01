package net.hemisoft.p2p.importer.finbee

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class FinbeeItemProcessor implements ItemProcessor<FinbeeTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(FinbeeTransactionDto dto) throws Exception {
		def entity    = new TransactionEntity()
		entity.id     = dto.ID
		entity.amount = dto.investedAmount
		entity.plattform = Plattform.FINBEE
		entity
	}

}
