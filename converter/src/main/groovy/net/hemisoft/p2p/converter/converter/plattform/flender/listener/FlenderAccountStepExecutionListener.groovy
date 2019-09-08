package net.hemisoft.p2p.converter.converter.plattform.flender.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.flender.service.FlenderAccountImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class FlenderAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.FLENDER

	FlenderAccountStepExecutionListener(FlenderAccountImportService service) {
		super(PLATTFORM, service)
	}
}
