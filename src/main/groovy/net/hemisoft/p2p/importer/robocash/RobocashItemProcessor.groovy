package net.hemisoft.p2p.importer.robocash

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class RobocashItemProcessor implements ItemProcessor<RobocashTransactionDto, TransactionEntity> {

	@Override
	public TransactionEntity process(RobocashTransactionDto dto) throws Exception {
		def entity    = new TransactionEntity()
		entity.id     = dto.ID
		entity.amount = dto.investedAmount
		entity.plattform = Plattform.ROBOCASH
		entity
	}

}
