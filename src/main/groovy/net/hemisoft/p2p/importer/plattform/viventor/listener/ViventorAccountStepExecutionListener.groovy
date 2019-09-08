package net.hemisoft.p2p.importer.plattform.viventor.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.twino.service.TwinoAccountImportService


@Slf4j
@Component
public class ViventorAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.VIVENTOR
	
	ViventorAccountStepExecutionListener(TwinoAccountImportService service) {
		super(PLATTFORM, service)
	}
}