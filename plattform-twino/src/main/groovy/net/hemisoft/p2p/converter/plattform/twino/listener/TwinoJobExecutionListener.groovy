package net.hemisoft.p2p.converter.plattform.twino.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.converter.plattform.twino.service.TwinoAccountImportService


@Slf4j
@Component
public class TwinoJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.TWINO

	TwinoJobExecutionListener(TwinoAccountImportService service) {
		super(PLATTFORM, service)
	}
}