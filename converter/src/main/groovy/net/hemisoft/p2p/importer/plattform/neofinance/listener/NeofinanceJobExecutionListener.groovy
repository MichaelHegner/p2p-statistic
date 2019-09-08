package net.hemisoft.p2p.importer.plattform.neofinance.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.neofinance.service.NeofinanceAccountImportService


@Slf4j
@Component
public class NeofinanceJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.NEOFINANCE

	NeofinanceJobExecutionListener(NeofinanceAccountImportService service) {
		super(PLATTFORM, service)
	}
}