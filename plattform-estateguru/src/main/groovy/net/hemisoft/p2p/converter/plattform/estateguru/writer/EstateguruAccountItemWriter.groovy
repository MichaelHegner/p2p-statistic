package net.hemisoft.p2p.converter.plattform.estateguru.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.plattform.estateguru.service.EstateguruAccountImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractAccountItemWriter

@Slf4j
@Component
class EstateguruAccountItemWriter extends AbstractAccountItemWriter {
	EstateguruAccountItemWriter(EstateguruAccountImportService service) {
		super(service)
	}
}