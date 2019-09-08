package net.hemisoft.p2p.converter.plattform.iuvo.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.iuvo.service.IuvoAccountImportService


@Slf4j
@Component
public class IuvoAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.IUVO
	
	IuvoAccountStepExecutionListener(IuvoAccountImportService service) {
		super(PLATTFORM, service)
	}
}