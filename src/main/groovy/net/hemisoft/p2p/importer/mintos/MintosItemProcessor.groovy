package net.hemisoft.p2p.importer.mintos

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class MintosItemProcessor implements ItemProcessor<MintosTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(MintosTransactionDto dto) throws Exception {
		def entity       = new TransactionEntity()
		entity.transactionId  = dto.transactionId
		entity.loanId         = dto.loanId
		entity.investedAmount = dto.investedAmount
		entity.plattform = Plattform.MINTOS
		entity
	}

}
