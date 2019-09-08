package net.hemisoft.p2p.converter.converter.plattform.investly.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.investly.service.InvestlyAccountImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class InvestlyJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.INVESTLY

	InvestlyJobExecutionListener(InvestlyAccountImportService service) {
		super(PLATTFORM, service)
	}
}