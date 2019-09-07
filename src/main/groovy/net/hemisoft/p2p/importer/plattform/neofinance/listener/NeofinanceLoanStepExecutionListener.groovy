package net.hemisoft.p2p.importer.plattform.neofinance.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.neofinance.service.NeofinanceLoanImportService


@Slf4j
@Component
public class NeofinanceLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.NEOFINANCE
	
	NeofinanceLoanStepExecutionListener(NeofinanceLoanImportService service) {
		super(PLATTFORM, service)
	}
}