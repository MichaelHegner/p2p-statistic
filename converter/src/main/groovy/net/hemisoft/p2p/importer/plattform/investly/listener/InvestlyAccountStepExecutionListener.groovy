package net.hemisoft.p2p.importer.plattform.investly.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.investly.service.InvestlyAccountImportService


@Slf4j
@Component
public class InvestlyAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.INVESTLY
	
	InvestlyAccountStepExecutionListener(InvestlyAccountImportService service) {
		super(PLATTFORM, service)
	}
}