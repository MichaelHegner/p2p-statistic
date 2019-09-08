package net.hemisoft.p2p.converter.plattform.debitum.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.debitum.service.DebitumAccountImportService
import net.hemisoft.p2p.converter.plattform.listener.AbstractAccountStepExecutionListener


@Slf4j
@Component
public class DebitumAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.DEBITUM
	
	DebitumAccountStepExecutionListener(DebitumAccountImportService service) {
		super(PLATTFORM, service)
	}
}