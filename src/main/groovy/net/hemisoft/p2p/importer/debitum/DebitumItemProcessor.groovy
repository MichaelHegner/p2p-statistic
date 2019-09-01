package net.hemisoft.p2p.importer.debitum

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class DebitumItemProcessor implements ItemProcessor<DebitumTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(DebitumTransactionDto dto) throws Exception {
		def entity    = new TransactionEntity()
		entity.transactionId  = dto.transactionId
		entity.loanId         = dto.loanId
		entity.investedAmount = dto.investedAmount
		entity.plattform = Plattform.DEBITUM
		entity
	}

}
