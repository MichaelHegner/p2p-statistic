package net.hemisoft.p2p.importer.plattform.grupeer.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.grupeer.service.GrupeerAccountImportService


@Slf4j
@Component
public class GrupeerAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.GRUPEER
	
	GrupeerAccountStepExecutionListener(GrupeerAccountImportService service) {
		super(PLATTFORM, service)
	}
}