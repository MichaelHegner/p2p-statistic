package net.hemisoft.p2p.converter.converter.plattform.neofinance.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.neofinance.service.NeofinanceAccountImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class NeofinanceJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.NEOFINANCE

	NeofinanceJobExecutionListener(NeofinanceAccountImportService service) {
		super(PLATTFORM, service)
	}
}