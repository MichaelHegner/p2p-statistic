package net.hemisoft.p2p.converter.converter.plattform.flender.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.writer.AbstractAccountItemWriter
import net.hemisoft.p2p.converter.converter.plattform.flender.service.FlenderAccountImportService

@Slf4j
@Component
class FlenderAccountItemWriter extends AbstractAccountItemWriter {
	FlenderAccountItemWriter(FlenderAccountImportService service) {
		super(service)
	}
}