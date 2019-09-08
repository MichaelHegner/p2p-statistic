package net.hemisoft.p2p.converter.converter.plattform.neofinance.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.neofinance.service.NeofinanceAccountImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class NeofinanceAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.NEOFINANCE
	
	NeofinanceAccountStepExecutionListener(NeofinanceAccountImportService service) {
		super(PLATTFORM, service)
	}
}