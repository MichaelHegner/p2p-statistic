package net.hemisoft.p2p.importer.plattform.viventor.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.viventor.service.ViventorLoanImportService


@Slf4j
@Component
public class ViventorLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.VIVENTOR
	
	ViventorLoanStepExecutionListener(ViventorLoanImportService service) {
		super(PLATTFORM, service)
	}
}