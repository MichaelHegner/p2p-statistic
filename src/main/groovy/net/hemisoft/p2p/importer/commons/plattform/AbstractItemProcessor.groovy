package net.hemisoft.p2p.importer.commons.plattform

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public abstract class AbstractItemProcessor<I extends AbstractTransactionDto, O extends TransactionEntity> implements ItemProcessor<I, O> {
	@Override
	public O process(I dto) throws Exception {
		def entity            = new TransactionEntity()
		entity.transactionId  = dto.transactionId
		entity.loan         = Loan.newInstance(loanId: dto.loanId)
		entity.investedAmount = dto.investedAmount
		entity.plattform      = createPlattform()
		entity
	}
	
	abstract Plattform createPlattform()
}
