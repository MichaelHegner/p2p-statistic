package net.hemisoft.p2p.importer.plattform.bondora.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.bondora.service.BondoraAccountImportService


@Slf4j
@Component
public class BondoraAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.BONDORA
	
	BondoraAccountStepExecutionListener(BondoraAccountImportService service) {
		super(PLATTFORM, service)
	}
}