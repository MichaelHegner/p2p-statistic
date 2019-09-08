package net.hemisoft.p2p.converter.plattform.peerberry.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.converter.domain.Loan
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.peerberry.dto.PeerberryLoanDto

@Component
public class PeerberryLoanItemProcessor extends AbstractLoanItemProcessor<PeerberryLoanDto, Loan> {
	@Override Loan process(PeerberryLoanDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.PEERBERRY }
}
