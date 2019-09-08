package net.hemisoft.p2p.importer.plattform.crowdestate.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.crowdestate.service.CrowdestateLoanImportService


@Slf4j
@Component
public class CrowdestateLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.CROWDESTATE
	
	CrowdestateLoanStepExecutionListener(CrowdestateLoanImportService service) {
		super(PLATTFORM, service)
	}
}