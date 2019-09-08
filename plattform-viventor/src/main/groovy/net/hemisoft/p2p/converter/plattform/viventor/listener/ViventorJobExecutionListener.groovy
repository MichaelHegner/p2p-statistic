package net.hemisoft.p2p.converter.plattform.viventor.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.converter.plattform.viventor.service.ViventorAccountImportService


@Slf4j
@Component
public class ViventorJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.TWINO

	ViventorJobExecutionListener(ViventorAccountImportService service) {
		super(PLATTFORM, service)
	}
}