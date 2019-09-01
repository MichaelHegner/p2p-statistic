package net.hemisoft.p2p.importer.plattform.iuvo

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class IuvoItemProcessor implements ItemProcessor<IuvoTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(IuvoTransactionDto dto) throws Exception {
		def entity    = new TransactionEntity()
		entity.transactionId  = dto.transactionId
		entity.loanId         = dto.loanId
		entity.investedAmount = dto.investedAmount
		entity.plattform = Plattform.IUVO
		entity
	}

}
