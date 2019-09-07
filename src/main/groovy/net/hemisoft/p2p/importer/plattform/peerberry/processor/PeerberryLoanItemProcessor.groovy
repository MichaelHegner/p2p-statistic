package net.hemisoft.p2p.importer.plattform.peerberry.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.peerberry.dto.PeerberryLoanDto

@Component
public class PeerberryLoanItemProcessor extends AbstractLoanItemProcessor<PeerberryLoanDto, Loan> {
	@Override Loan process(PeerberryLoanDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.PEERBERRY }
}
