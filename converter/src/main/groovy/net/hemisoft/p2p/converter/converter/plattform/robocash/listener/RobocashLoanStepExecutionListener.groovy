package net.hemisoft.p2p.converter.converter.plattform.robocash.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.robocash.service.RobocashLoanImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class RobocashLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.ROBOCASH
	
	RobocashLoanStepExecutionListener(RobocashLoanImportService service) {
		super(PLATTFORM, service)
	}
}