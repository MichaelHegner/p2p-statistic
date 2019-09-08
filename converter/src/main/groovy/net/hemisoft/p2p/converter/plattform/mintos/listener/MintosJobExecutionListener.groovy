package net.hemisoft.p2p.converter.plattform.mintos.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.converter.domain.Plattform
import net.hemisoft.p2p.converter.plattform.mintos.service.MintosAccountImportService


@Slf4j
@Component
public class MintosJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.MINTOS

	MintosJobExecutionListener(MintosAccountImportService service) {
		super(PLATTFORM, service)
	}
}