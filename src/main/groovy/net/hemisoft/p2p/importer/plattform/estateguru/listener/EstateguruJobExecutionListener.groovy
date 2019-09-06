package net.hemisoft.p2p.importer.plattform.estateguru.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.estateguru.service.EstateguruAccountImportService


@Slf4j
@Component
public class EstateguruJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.ESTATEGURU

	EstateguruJobExecutionListener(EstateguruAccountImportService service) {
		super(PLATTFORM, service)
	}
}