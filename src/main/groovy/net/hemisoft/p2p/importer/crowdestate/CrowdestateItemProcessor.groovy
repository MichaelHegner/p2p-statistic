package net.hemisoft.p2p.importer.crowdestate

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class CrowdestateItemProcessor implements ItemProcessor<CrowdestateTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(CrowdestateTransactionDto dto) throws Exception {
		def entity    = new TransactionEntity()
		entity.id     = dto.ID
		entity.amount = dto.investedAmount
		entity.plattform = Plattform.CROWDESTATE
		entity
	}

}
