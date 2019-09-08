package net.hemisoft.p2p.converter.plattform.mintos.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.mintos.service.MintosLoanImportService


@Slf4j
@Component
public class MintosLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.MINTOS
	
	MintosLoanStepExecutionListener(MintosLoanImportService service) {
		super(PLATTFORM, service)
	}
}