package net.hemisoft.p2p.converter.plattform.finbee.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.finbee.service.FinbeeLoanImportService


@Slf4j
@Component
public class FinbeeLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.FINBEE
	
	FinbeeLoanStepExecutionListener(FinbeeLoanImportService service) {
		super(PLATTFORM, service)
	}
}
