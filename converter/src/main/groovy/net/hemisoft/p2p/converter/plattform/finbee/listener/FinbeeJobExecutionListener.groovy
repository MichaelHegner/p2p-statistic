package net.hemisoft.p2p.converter.plattform.finbee.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.finbee.service.FinbeeAccountImportService


@Slf4j
@Component
public class FinbeeJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.FINBEE

	FinbeeJobExecutionListener(FinbeeAccountImportService service) {
		super(PLATTFORM, service)
	}
}