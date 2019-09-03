package net.hemisoft.p2p.importer.plattform.robocash

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.domain.TransactionEntity

public class RobocashItemProcessor extends AbstractItemProcessor<RobocashTransactionDto, TransactionEntity> {

	@Override TransactionEntity process(RobocashTransactionDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform() { Plattform.ROBOCASH }
}