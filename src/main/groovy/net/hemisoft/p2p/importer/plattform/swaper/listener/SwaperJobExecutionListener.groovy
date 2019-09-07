package net.hemisoft.p2p.importer.plattform.swaper.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.swaper.service.SwaperAccountImportService


@Slf4j
@Component
public class SwaperJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.SWAPER

	SwaperJobExecutionListener(SwaperAccountImportService service) {
		super(PLATTFORM, service)
	}
}