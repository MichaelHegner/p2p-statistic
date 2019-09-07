package net.hemisoft.p2p.importer.plattform.iuvo.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.iuvo.service.IuvoAccountImportService


@Slf4j
@Component
public class IuvoAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.IUVO
	
	IuvoAccountStepExecutionListener(IuvoAccountImportService service) {
		super(PLATTFORM, service)
	}
}