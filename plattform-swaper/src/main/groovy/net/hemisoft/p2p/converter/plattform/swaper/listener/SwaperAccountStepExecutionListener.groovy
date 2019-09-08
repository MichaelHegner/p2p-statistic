package net.hemisoft.p2p.converter.plattform.swaper.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.converter.plattform.swaper.service.SwaperAccountImportService


@Slf4j
@Component
public class SwaperAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.SWAPER
	
	SwaperAccountStepExecutionListener(SwaperAccountImportService service) {
		super(PLATTFORM, service)
	}
}