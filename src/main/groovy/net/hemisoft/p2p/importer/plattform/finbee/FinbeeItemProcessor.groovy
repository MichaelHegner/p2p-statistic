package net.hemisoft.p2p.importer.plattform.finbee

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class FinbeeItemProcessor implements ItemProcessor<FinbeeTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(FinbeeTransactionDto dto) throws Exception {
		def entity    = new TransactionEntity()
		entity.transactionId  = dto.transactionId
		entity.loanId         = dto.loanId
		entity.investedAmount = dto.investedAmount
		entity.plattform = Plattform.FINBEE
		entity
	}

}
