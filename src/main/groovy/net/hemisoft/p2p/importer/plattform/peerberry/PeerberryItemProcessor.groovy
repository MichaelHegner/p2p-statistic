package net.hemisoft.p2p.importer.plattform.peerberry

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class PeerberryItemProcessor extends AbstractLoanItemProcessor<PeerberryTransactionDto, Loan> {

	@Override Loan process(PeerberryTransactionDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.PEERBERRY }
}
