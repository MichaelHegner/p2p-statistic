package net.hemisoft.p2p.converter.plattform.estateguru.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.estateguru.service.EstateguruLoanImportService


@Slf4j
@Component
public class EstateguruLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.ESTATEGURU
	
	EstateguruLoanStepExecutionListener(EstateguruLoanImportService service) {
		super(PLATTFORM, service)
	}
}