package net.hemisoft.p2p.importer.plattform.finbee.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.finbee.service.FinbeeAccountImportService


@Slf4j
@Component
public class FinbeeJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.FINBEE

	FinbeeJobExecutionListener(FinbeeAccountImportService service) {
		super(PLATTFORM, service)
	}
}