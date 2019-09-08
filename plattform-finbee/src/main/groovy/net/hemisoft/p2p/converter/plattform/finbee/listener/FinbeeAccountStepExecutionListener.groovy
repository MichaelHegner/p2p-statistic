package net.hemisoft.p2p.converter.plattform.finbee.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.finbee.service.FinbeeAccountImportService
import net.hemisoft.p2p.converter.plattform.listener.AbstractAccountStepExecutionListener


@Slf4j
@Component
public class FinbeeAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.FINBEE
	
	FinbeeAccountStepExecutionListener(FinbeeAccountImportService service) {
		super(PLATTFORM, service)
	}
}
