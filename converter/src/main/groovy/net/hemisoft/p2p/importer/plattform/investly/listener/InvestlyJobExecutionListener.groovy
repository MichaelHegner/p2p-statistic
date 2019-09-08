package net.hemisoft.p2p.importer.plattform.investly.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.investly.service.InvestlyAccountImportService


@Slf4j
@Component
public class InvestlyJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.INVESTLY

	InvestlyJobExecutionListener(InvestlyAccountImportService service) {
		super(PLATTFORM, service)
	}
}