package net.hemisoft.p2p.converter.plattform.viventor.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.converter.plattform.viventor.service.ViventorLoanImportService


@Slf4j
@Component
public class ViventorLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.VIVENTOR
	
	ViventorLoanStepExecutionListener(ViventorLoanImportService service) {
		super(PLATTFORM, service)
	}
}