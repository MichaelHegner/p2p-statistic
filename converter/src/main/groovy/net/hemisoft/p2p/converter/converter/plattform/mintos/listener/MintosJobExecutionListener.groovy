package net.hemisoft.p2p.converter.converter.plattform.mintos.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.mintos.service.MintosAccountImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class MintosJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.MINTOS

	MintosJobExecutionListener(MintosAccountImportService service) {
		super(PLATTFORM, service)
	}
}