package net.hemisoft.p2p.converter.plattform.grupeer.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.grupeer.service.GrupeerAccountImportService
import net.hemisoft.p2p.converter.plattform.listener.AbstractAccountStepExecutionListener


@Slf4j
@Component
public class GrupeerAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.GRUPEER
	
	GrupeerAccountStepExecutionListener(GrupeerAccountImportService service) {
		super(PLATTFORM, service)
	}
}