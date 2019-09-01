package net.hemisoft.p2p.importer.neofinance

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class NeofinanceItemProcessor implements ItemProcessor<NeofinanceTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(NeofinanceTransactionDto dto) throws Exception {
		def entity    = new TransactionEntity()
		entity.transactionId  = dto.transactionId
		entity.loanId         = dto.loanId
		entity.investedAmount = dto.investedAmount
		entity.plattform = Plattform.NEOFINANCE
		entity
	}

}
