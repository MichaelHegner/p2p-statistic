package net.hemisoft.p2p.converter.plattform.bondora.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.bondora.service.BondoraLoanImportService


@Slf4j
@Component
public class BondoraLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.BONDORA
	
	BondoraLoanStepExecutionListener(BondoraLoanImportService service) {
		super(PLATTFORM, service)
	}
}