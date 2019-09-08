package net.hemisoft.p2p.importer.plattform.robocash.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.robocash.service.RobocashLoanImportService


@Slf4j
@Component
public class RobocashLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.ROBOCASH
	
	RobocashLoanStepExecutionListener(RobocashLoanImportService service) {
		super(PLATTFORM, service)
	}
}