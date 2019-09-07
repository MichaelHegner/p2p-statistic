package net.hemisoft.p2p.importer.plattform.mintos.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.listener.AbstractAccountStepExecutionListener
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.mintos.service.MintosAccountImportService


@Slf4j
@Component
public class MintosAccountStepExecutionListener extends AbstractAccountStepExecutionListener {
	private static final Plattform PLATTFORM = Plattform.MINTOS
	
	MintosAccountStepExecutionListener(MintosAccountImportService service) {
		super(PLATTFORM, service)
	}
}