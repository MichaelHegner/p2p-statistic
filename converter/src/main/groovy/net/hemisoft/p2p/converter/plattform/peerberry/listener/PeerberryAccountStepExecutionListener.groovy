package net.hemisoft.p2p.converter.plattform.peerberry.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.peerberry.service.PeerberryAccountImportService


@Slf4j
@Component
public class PeerberryAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.PEERBERRY
	
	PeerberryAccountStepExecutionListener(PeerberryAccountImportService service) {
		super(PLATTFORM, service)
	}
}