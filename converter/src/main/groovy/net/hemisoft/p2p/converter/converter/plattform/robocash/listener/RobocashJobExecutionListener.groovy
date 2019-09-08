package net.hemisoft.p2p.converter.converter.plattform.robocash.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.robocash.service.RobocashAccountImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class RobocashJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.ROBOCASH

	RobocashJobExecutionListener(RobocashAccountImportService service) {
		super(PLATTFORM, service)
	}
}