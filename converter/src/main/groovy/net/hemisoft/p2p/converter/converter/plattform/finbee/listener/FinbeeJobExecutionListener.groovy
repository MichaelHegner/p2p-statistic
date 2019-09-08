package net.hemisoft.p2p.converter.converter.plattform.finbee.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.plattform.finbee.service.FinbeeAccountImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.listener.AbstractJobExecutionListener


@Slf4j
@Component
public class FinbeeJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.FINBEE

	FinbeeJobExecutionListener(FinbeeAccountImportService service) {
		super(PLATTFORM, service)
	}
}