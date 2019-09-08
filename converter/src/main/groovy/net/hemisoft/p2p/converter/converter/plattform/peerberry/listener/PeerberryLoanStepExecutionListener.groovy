package net.hemisoft.p2p.converter.converter.plattform.peerberry.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.peerberry.service.PeerberryLoanImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class PeerberryLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.PEERBERRY
	
	PeerberryLoanStepExecutionListener(PeerberryLoanImportService service) {
		super(PLATTFORM, service)
	}
}