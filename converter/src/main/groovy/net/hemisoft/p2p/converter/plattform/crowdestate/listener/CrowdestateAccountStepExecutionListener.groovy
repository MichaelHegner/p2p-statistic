package net.hemisoft.p2p.converter.plattform.crowdestate.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.crowdestate.service.CrowdestateAccountImportService


@Slf4j
@Component
public class CrowdestateAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.CROWDESTATE
	
	CrowdestateAccountStepExecutionListener(CrowdestateAccountImportService service) {
		super(PLATTFORM, service)
	}
}