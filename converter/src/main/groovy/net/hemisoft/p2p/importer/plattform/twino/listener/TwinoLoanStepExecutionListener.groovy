package net.hemisoft.p2p.importer.plattform.twino.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.twino.service.TwinoLoanImportService


@Slf4j
@Component
public class TwinoLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.TWINO
	
	TwinoLoanStepExecutionListener(TwinoLoanImportService service) {
		super(PLATTFORM, service)
	}
}