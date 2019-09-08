package net.hemisoft.p2p.converter.plattform.flender.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.flender.service.FlenderAccountImportService


@Slf4j
@Component
public class FlenderJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.FLENDER

	FlenderJobExecutionListener(FlenderAccountImportService service) {
		super(PLATTFORM, service)
	}
}