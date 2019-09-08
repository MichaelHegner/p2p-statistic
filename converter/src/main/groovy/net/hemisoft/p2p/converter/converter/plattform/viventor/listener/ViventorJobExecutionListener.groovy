package net.hemisoft.p2p.converter.converter.plattform.viventor.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.twino.service.TwinoAccountImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class ViventorJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.TWINO

	ViventorJobExecutionListener(TwinoAccountImportService service) {
		super(PLATTFORM, service)
	}
}