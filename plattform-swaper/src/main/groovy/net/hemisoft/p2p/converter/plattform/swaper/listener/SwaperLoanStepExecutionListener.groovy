package net.hemisoft.p2p.converter.plattform.swaper.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.converter.plattform.swaper.service.SwaperLoanImportService


@Slf4j
@Component
public class SwaperLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.SWAPER
	
	SwaperLoanStepExecutionListener(SwaperLoanImportService service) {
		super(PLATTFORM, service)
	}
}