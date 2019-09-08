package net.hemisoft.p2p.converter.plattform.neofinance.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.neofinance.service.NeofinanceAccountImportService


@Slf4j
@Component
public class NeofinanceAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.NEOFINANCE
	
	NeofinanceAccountStepExecutionListener(NeofinanceAccountImportService service) {
		super(PLATTFORM, service)
	}
}