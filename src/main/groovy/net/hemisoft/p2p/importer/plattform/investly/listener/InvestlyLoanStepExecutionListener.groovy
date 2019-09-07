package net.hemisoft.p2p.importer.plattform.investly.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.investly.service.InvestlyLoanImportService


@Slf4j
@Component
public class InvestlyLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.INVESTLY
	
	InvestlyLoanStepExecutionListener(InvestlyLoanImportService service) {
		super(PLATTFORM, service)
	}
}