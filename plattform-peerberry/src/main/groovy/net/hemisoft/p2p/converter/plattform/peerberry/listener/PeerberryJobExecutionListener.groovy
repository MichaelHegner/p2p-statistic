package net.hemisoft.p2p.converter.plattform.peerberry.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.converter.plattform.peerberry.service.PeerberryAccountImportService


@Slf4j
@Component
public class PeerberryJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.PEERBERRY

	PeerberryJobExecutionListener(PeerberryAccountImportService service) {
		super(PLATTFORM, service)
	}
}