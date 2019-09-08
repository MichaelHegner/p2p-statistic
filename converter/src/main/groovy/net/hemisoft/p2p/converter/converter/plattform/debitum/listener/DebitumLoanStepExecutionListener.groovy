package net.hemisoft.p2p.converter.converter.plattform.debitum.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractLoanStepExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.debitum.service.DebitumLoanImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class DebitumLoanStepExecutionListener extends AbstractLoanStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.DEBITUM
	
	DebitumLoanStepExecutionListener(DebitumLoanImportService service) {
		super(PLATTFORM, service)
	}
}