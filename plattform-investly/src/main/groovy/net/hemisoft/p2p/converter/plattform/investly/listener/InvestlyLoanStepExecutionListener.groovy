package net.hemisoft.p2p.converter.plattform.investly.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.investly.service.InvestlyLoanImportService
import net.hemisoft.p2p.converter.plattform.listener.AbstractLoanStepExecutionListener


@Slf4j
@Component
public class InvestlyLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.INVESTLY
	
	InvestlyLoanStepExecutionListener(InvestlyLoanImportService service) {
		super(PLATTFORM, service)
	}
}