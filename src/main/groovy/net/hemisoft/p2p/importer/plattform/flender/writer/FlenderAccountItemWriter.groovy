package net.hemisoft.p2p.importer.plattform.flender.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractAccountItemWriter
import net.hemisoft.p2p.importer.plattform.flender.service.FlenderAccountImportService

@Slf4j
@Component
class FlenderAccountItemWriter extends AbstractAccountItemWriter {
	FlenderAccountItemWriter(FlenderAccountImportService service) {
		super(service)
	}
}