package net.hemisoft.p2p.converter.converter.plattform.debitum.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.debitum.service.DebitumAccountImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class DebitumJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.DEBITUM

	DebitumJobExecutionListener(DebitumAccountImportService service) {
		super(PLATTFORM, service)
	}
}