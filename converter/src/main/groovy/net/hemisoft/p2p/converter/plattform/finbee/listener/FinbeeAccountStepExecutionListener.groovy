package net.hemisoft.p2p.converter.plattform.finbee.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.finbee.service.FinbeeAccountImportService


@Slf4j
@Component
public class FinbeeAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.FINBEE
	
	FinbeeAccountStepExecutionListener(FinbeeAccountImportService service) {
		super(PLATTFORM, service)
	}
}
