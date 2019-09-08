package net.hemisoft.p2p.importer.plattform.finbee.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.finbee.service.FinbeeLoanImportService


@Slf4j
@Component
public class FinbeeLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.FINBEE
	
	FinbeeLoanStepExecutionListener(FinbeeLoanImportService service) {
		super(PLATTFORM, service)
	}
}
