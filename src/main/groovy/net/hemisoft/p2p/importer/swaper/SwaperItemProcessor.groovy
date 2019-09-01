package net.hemisoft.p2p.importer.swaper

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class SwaperItemProcessor implements ItemProcessor<SwaperTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(SwaperTransactionDto dto) throws Exception {
		def entity    = new TransactionEntity()
		entity.transactionId  = dto.transactionId
		entity.loanId         = dto.loanId
		entity.investedAmount = dto.investedAmount
		entity.plattform = Plattform.SWAPER
		entity
	}

}
