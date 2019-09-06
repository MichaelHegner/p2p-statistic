package net.hemisoft.p2p.importer.plattform.debitum.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.debitum.service.DebitumAccountImportService


@Slf4j
@Component
public class DebitumAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.DEBITUM
	
	DebitumAccountStepExecutionListener(DebitumAccountImportService service) {
		super(PLATTFORM, service)
	}
}