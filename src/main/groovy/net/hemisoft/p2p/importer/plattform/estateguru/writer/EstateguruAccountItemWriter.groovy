package net.hemisoft.p2p.importer.plattform.estateguru.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractAccountItemWriter
import net.hemisoft.p2p.importer.plattform.estateguru.service.EstateguruAccountImportService

@Slf4j
@Component
class EstateguruAccountItemWriter extends AbstractAccountItemWriter {
	EstateguruAccountItemWriter(EstateguruAccountImportService service) {
		super(service)
	}
}