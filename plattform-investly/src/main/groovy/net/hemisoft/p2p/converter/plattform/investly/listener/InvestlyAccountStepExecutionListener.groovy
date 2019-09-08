package net.hemisoft.p2p.converter.plattform.investly.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.investly.service.InvestlyAccountImportService
import net.hemisoft.p2p.converter.plattform.listener.AbstractAccountStepExecutionListener


@Slf4j
@Component
public class InvestlyAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.INVESTLY
	
	InvestlyAccountStepExecutionListener(InvestlyAccountImportService service) {
		super(PLATTFORM, service)
	}
}