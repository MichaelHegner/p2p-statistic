package net.hemisoft.p2p.converter.plattform.estateguru.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.estateguru.service.EstateguruAccountImportService
import net.hemisoft.p2p.converter.plattform.listener.AbstractAccountStepExecutionListener


@Slf4j
@Component
public class EstateguruAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.ESTATEGURU
	
	EstateguruAccountStepExecutionListener(EstateguruAccountImportService service) {
		super(PLATTFORM, service)
	}
}