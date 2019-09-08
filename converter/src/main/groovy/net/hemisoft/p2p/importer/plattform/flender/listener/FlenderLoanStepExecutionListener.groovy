package net.hemisoft.p2p.importer.plattform.flender.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.flender.service.FlenderLoanImportService


@Slf4j
@Component
public class FlenderLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.FLENDER

	FlenderLoanStepExecutionListener(FlenderLoanImportService service) {
		super(PLATTFORM, service)
	}
}
