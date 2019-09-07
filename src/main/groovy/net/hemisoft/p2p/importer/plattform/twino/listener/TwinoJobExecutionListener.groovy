package net.hemisoft.p2p.importer.plattform.twino.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.twino.service.TwinoAccountImportService


@Slf4j
@Component
public class TwinoJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.TWINO

	TwinoJobExecutionListener(TwinoAccountImportService service) {
		super(PLATTFORM, service)
	}
}