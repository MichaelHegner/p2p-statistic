package net.hemisoft.p2p.converter.converter.plattform.peerberry.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.converter.converter.plattform.peerberry.dto.PeerberryLoanDto
import net.hemisoft.p2p.converter.domain.entity.Loan
import net.hemisoft.p2p.converter.domain.entity.Plattform

@Component
public class PeerberryLoanItemProcessor extends AbstractLoanItemProcessor<PeerberryLoanDto, Loan> {
	@Override Loan process(PeerberryLoanDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.PEERBERRY }
}
