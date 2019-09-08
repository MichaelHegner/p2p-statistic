package net.hemisoft.p2p.converter.converter.plattform.swaper.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.swaper.service.SwaperAccountImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class SwaperAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.SWAPER
	
	SwaperAccountStepExecutionListener(SwaperAccountImportService service) {
		super(PLATTFORM, service)
	}
}