package net.hemisoft.p2p.converter.converter.plattform.bondora.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.bondora.service.BondoraAccountImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class BondoraJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.BONDORA

	BondoraJobExecutionListener(BondoraAccountImportService service) {
		super(PLATTFORM, service)
	}
}