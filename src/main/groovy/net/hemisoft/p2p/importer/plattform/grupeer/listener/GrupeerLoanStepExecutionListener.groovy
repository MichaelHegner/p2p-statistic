package net.hemisoft.p2p.importer.plattform.grupeer.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.grupeer.service.GrupeerLoanImportService


@Slf4j
@Component
public class GrupeerLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.GRUPEER
	
	GrupeerLoanStepExecutionListener(GrupeerLoanImportService service) {
		super(PLATTFORM, service)
	}
}