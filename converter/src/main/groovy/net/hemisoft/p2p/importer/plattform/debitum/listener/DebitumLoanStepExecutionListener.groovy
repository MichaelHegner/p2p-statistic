package net.hemisoft.p2p.importer.plattform.debitum.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.debitum.service.DebitumLoanImportService


@Slf4j
@Component
public class DebitumLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.DEBITUM
	
	DebitumLoanStepExecutionListener(DebitumLoanImportService service) {
		super(PLATTFORM, service)
	}
}