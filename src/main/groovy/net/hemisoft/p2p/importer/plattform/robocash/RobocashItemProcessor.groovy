package net.hemisoft.p2p.importer.plattform.robocash

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class RobocashItemProcessor extends AbstractItemProcessor<RobocashTransactionDto, Loan> {

	@Override Loan process(RobocashTransactionDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.ROBOCASH }
}
