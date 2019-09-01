package net.hemisoft.p2p.importer.investly

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class InvestlyItemProcessor implements ItemProcessor<InvestlyTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(InvestlyTransactionDto dto) throws Exception {
		def entity    = new TransactionEntity()
		entity.id     = dto.ID
		entity.amount = dto.investedAmount
		entity.plattform = Plattform.INVESTLY
		entity
	}

}
