package net.hemisoft.p2p.converter.plattform.viventor.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.converter.plattform.viventor.service.ViventorAccountImportService


@Slf4j
@Component
public class ViventorAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.VIVENTOR
	
	ViventorAccountStepExecutionListener(ViventorAccountImportService service) {
		super(PLATTFORM, service)
	}
}