package net.hemisoft.p2p.converter.converter.plattform.crowdestate.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.crowdestate.service.CrowdestateAccountImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class CrowdestateJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.CROWDESTATE

	CrowdestateJobExecutionListener(CrowdestateAccountImportService service) {
		super(PLATTFORM, service)
	}
}