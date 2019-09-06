package net.hemisoft.p2p.importer.plattform.estateguru.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.estateguru.service.EstateguruAccountImportService


@Slf4j
@Component
public class EstateguruAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.ESTATEGURU
	
	EstateguruAccountStepExecutionListener(EstateguruAccountImportService service) {
		super(PLATTFORM, service)
	}
}