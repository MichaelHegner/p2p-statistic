package net.hemisoft.p2p.importer.grupeer

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class GrupeerItemProcessor implements ItemProcessor<GrupeerTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(GrupeerTransactionDto dto) throws Exception {
		def entity    = new TransactionEntity()
		entity.transactionId  = dto.transactionId
		entity.loanId         = dto.loanId
		entity.investedAmount = dto.investedAmount
		entity.plattform = Plattform.GRUPEER
		entity
	}

}
