package net.hemisoft.p2p.converter.converter.plattform.viventor.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.twino.service.TwinoAccountImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class ViventorAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.VIVENTOR
	
	ViventorAccountStepExecutionListener(TwinoAccountImportService service) {
		super(PLATTFORM, service)
	}
}