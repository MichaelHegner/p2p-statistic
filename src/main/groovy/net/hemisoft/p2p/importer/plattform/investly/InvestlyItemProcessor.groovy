package net.hemisoft.p2p.importer.plattform.investly

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class InvestlyItemProcessor implements ItemProcessor<InvestlyTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(InvestlyTransactionDto dto) throws Exception {
		def entity    = new TransactionEntity()
		entity.transactionId  = dto.transactionId
		entity.loanId         = dto.loanId
		entity.investedAmount = dto.investedAmount
		entity.plattform = Plattform.INVESTLY
		entity
	}

}
