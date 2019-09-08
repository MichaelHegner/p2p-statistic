package net.hemisoft.p2p.converter.plattform.neofinance.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.converter.plattform.neofinance.service.NeofinanceLoanImportService


@Slf4j
@Component
public class NeofinanceLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.NEOFINANCE
	
	NeofinanceLoanStepExecutionListener(NeofinanceLoanImportService service) {
		super(PLATTFORM, service)
	}
}