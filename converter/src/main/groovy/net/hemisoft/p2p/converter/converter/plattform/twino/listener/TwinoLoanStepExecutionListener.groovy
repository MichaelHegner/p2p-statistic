package net.hemisoft.p2p.converter.converter.plattform.twino.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.twino.service.TwinoLoanImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class TwinoLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.TWINO
	
	TwinoLoanStepExecutionListener(TwinoLoanImportService service) {
		super(PLATTFORM, service)
	}
}