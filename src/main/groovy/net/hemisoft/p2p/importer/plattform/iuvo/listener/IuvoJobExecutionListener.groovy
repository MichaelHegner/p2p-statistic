package net.hemisoft.p2p.importer.plattform.iuvo.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.iuvo.service.IuvoAccountImportService


@Slf4j
@Component
public class IuvoJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.IUVO

	IuvoJobExecutionListener(IuvoAccountImportService service) {
		super(PLATTFORM, service)
	}
}