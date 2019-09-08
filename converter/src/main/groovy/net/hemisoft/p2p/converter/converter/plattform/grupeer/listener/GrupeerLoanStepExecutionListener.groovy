package net.hemisoft.p2p.converter.converter.plattform.grupeer.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.grupeer.service.GrupeerLoanImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class GrupeerLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.GRUPEER
	
	GrupeerLoanStepExecutionListener(GrupeerLoanImportService service) {
		super(PLATTFORM, service)
	}
}