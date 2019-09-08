package net.hemisoft.p2p.converter.plattform.grupeer.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.grupeer.service.GrupeerAccountImportService


@Slf4j
@Component
public class GrupeerJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.GRUPEER

	GrupeerJobExecutionListener(GrupeerAccountImportService service) {
		super(PLATTFORM, service)
	}
}