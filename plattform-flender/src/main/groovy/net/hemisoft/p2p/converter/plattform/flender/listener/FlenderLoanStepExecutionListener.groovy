package net.hemisoft.p2p.converter.plattform.flender.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.flender.service.FlenderLoanImportService
import net.hemisoft.p2p.converter.plattform.listener.AbstractLoanStepExecutionListener


@Slf4j
@Component
public class FlenderLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.FLENDER

	FlenderLoanStepExecutionListener(FlenderLoanImportService service) {
		super(PLATTFORM, service)
	}
}
