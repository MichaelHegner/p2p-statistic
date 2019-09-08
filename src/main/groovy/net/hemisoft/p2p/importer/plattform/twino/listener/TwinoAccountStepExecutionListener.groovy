package net.hemisoft.p2p.importer.plattform.twino.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.twino.service.TwinoAccountImportService


@Slf4j
@Component
public class TwinoAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.TWINO
	
	TwinoAccountStepExecutionListener(TwinoAccountImportService service) {
		super(PLATTFORM, service)
	}
}