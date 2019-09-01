package net.hemisoft.p2p.importer.viventor

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class ViventorItemProcessor implements ItemProcessor<ViventorTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(ViventorTransactionDto dto) throws Exception {
		def entity    = new TransactionEntity()
		entity.transactionId  = dto.transactionId
		entity.loanId         = dto.loanId
		entity.investedAmount = dto.investedAmount
		entity.plattform = Plattform.VIVENTOR
		entity
	}

}
