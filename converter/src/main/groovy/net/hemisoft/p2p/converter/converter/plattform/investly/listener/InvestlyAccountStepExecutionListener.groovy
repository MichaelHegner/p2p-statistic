package net.hemisoft.p2p.converter.converter.plattform.investly.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.investly.service.InvestlyAccountImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class InvestlyAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.INVESTLY
	
	InvestlyAccountStepExecutionListener(InvestlyAccountImportService service) {
		super(PLATTFORM, service)
	}
}