package net.hemisoft.p2p.converter.plattform.robocash.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.robocash.service.RobocashAccountImportService


@Slf4j
@Component
public class RobocashAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.ROBOCASH
	
	RobocashAccountStepExecutionListener(RobocashAccountImportService service) {
		super(PLATTFORM, service)
	}
}