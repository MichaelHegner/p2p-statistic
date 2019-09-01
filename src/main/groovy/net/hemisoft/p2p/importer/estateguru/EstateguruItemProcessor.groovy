package net.hemisoft.p2p.importer.estateguru

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class EstateguruItemProcessor implements ItemProcessor<EstateguruTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(EstateguruTransactionDto dto) throws Exception {
		def entity    = new TransactionEntity()
		entity.transactionId  = dto.transactionId
		entity.loanId         = dto.loanId
		entity.investedAmount = dto.investedAmount
		entity.plattform = Plattform.ESTATEGURU
		entity
	}

}
