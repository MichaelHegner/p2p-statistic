package net.hemisoft.p2p.converter.converter.plattform.bondora.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.bondora.service.BondoraAccountImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class BondoraAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.BONDORA
	
	BondoraAccountStepExecutionListener(BondoraAccountImportService service) {
		super(PLATTFORM, service)
	}
}