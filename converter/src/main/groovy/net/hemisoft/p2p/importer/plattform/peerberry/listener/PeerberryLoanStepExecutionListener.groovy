package net.hemisoft.p2p.importer.plattform.peerberry.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.peerberry.service.PeerberryLoanImportService


@Slf4j
@Component
public class PeerberryLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.PEERBERRY
	
	PeerberryLoanStepExecutionListener(PeerberryLoanImportService service) {
		super(PLATTFORM, service)
	}
}