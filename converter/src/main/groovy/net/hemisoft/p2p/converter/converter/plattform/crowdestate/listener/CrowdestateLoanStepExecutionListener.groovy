package net.hemisoft.p2p.converter.converter.plattform.crowdestate.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.plattform.crowdestate.service.CrowdestateLoanImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.listener.AbstractLoanStepExecutionListener


@Slf4j
@Component
public class CrowdestateLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.CROWDESTATE
	
	CrowdestateLoanStepExecutionListener(CrowdestateLoanImportService service) {
		super(PLATTFORM, service)
	}
}