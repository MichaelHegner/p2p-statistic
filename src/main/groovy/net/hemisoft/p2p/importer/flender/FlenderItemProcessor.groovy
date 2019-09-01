package net.hemisoft.p2p.importer.flender

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class FlenderItemProcessor implements ItemProcessor<FlenderTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(FlenderTransactionDto dto) throws Exception {
		def entity    = new TransactionEntity()
		entity.transactionId  = dto.transactionId
		entity.loanId         = dto.loanId
		entity.investedAmount = dto.investedAmount
		entity.plattform = Plattform.FLENDER
		entity
	}

}
