package net.hemisoft.p2p.converter.plattform.peerberry.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.peerberry.dto.PeerberryAccountDto
import net.hemisoft.p2p.converter.plattform.processor.AbstractAccountItemProcessor

@Component
public class PeerberryAccountItemProcessor extends AbstractAccountItemProcessor<PeerberryAccountDto, Account> {
	@Override Account process(PeerberryAccountDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.PEERBERRY }
}
