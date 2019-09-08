package net.hemisoft.p2p.converter.converter.plattform.grupeer.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.grupeer.service.GrupeerAccountImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class GrupeerJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.GRUPEER

	GrupeerJobExecutionListener(GrupeerAccountImportService service) {
		super(PLATTFORM, service)
	}
}