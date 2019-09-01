package net.hemisoft.p2p.importer.plattform.twino

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class TwinoItemProcessor implements ItemProcessor<TwinoTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(TwinoTransactionDto dto) throws Exception {
		def entity    = new TransactionEntity()
		entity.transactionId  = dto.transactionId
		entity.loanId         = dto.loanId
		entity.investedAmount = dto.investedAmount
		entity.plattform = Plattform.TWINO
		entity
	}

}
