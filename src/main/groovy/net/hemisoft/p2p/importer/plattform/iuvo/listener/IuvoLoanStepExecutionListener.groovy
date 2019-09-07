package net.hemisoft.p2p.importer.plattform.iuvo.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.iuvo.service.IuvoLoanImportService


@Slf4j
@Component
public class IuvoLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.IUVO
	
	IuvoLoanStepExecutionListener(IuvoLoanImportService service) {
		super(PLATTFORM, service)
	}
}