package net.hemisoft.p2p.importer.plattform.debitum.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.debitum.service.DebitumAccountImportService


@Slf4j
@Component
public class DebitumJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.DEBITUM

	DebitumJobExecutionListener(DebitumAccountImportService service) {
		super(PLATTFORM, service)
	}
}