package net.hemisoft.p2p.importer.plattform.flender.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.flender.service.FlenderAccountImportService


@Slf4j
@Component
public class FlenderAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.FLENDER

	FlenderAccountStepExecutionListener(FlenderAccountImportService service) {
		super(PLATTFORM, service)
	}
}