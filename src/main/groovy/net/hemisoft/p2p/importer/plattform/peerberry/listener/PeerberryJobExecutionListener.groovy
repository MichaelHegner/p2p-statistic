package net.hemisoft.p2p.importer.plattform.peerberry.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.peerberry.service.PeerberryAccountImportService


@Slf4j
@Component
public class PeerberryJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.PEERBERRY

	PeerberryJobExecutionListener(PeerberryAccountImportService service) {
		super(PLATTFORM, service)
	}
}