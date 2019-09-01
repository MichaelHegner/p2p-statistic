package net.hemisoft.p2p.importer.iuvo

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class IuvoItemProcessor implements ItemProcessor<IuvoTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(IuvoTransactionDto dto) throws Exception {
		def entity    = new TransactionEntity()
		entity.id     = dto.ID
		entity.amount = dto.investedAmount
		entity.plattform = Plattform.IUVO
		entity
	}

}