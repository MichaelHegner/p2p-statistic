package net.hemisoft.p2p.converter.converter.plattform.estateguru.listener

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.listener.AbstractJobExecutionListener
import net.hemisoft.p2p.converter.converter.plattform.estateguru.service.EstateguruAccountImportService
import net.hemisoft.p2p.converter.domain.entity.Plattform


@Slf4j
@Component
public class EstateguruJobExecutionListener extends AbstractJobExecutionListener {
	private static final Plattform PLATTFORM = Plattform.ESTATEGURU

	EstateguruJobExecutionListener(EstateguruAccountImportService service) {
		super(PLATTFORM, service)
	}
}