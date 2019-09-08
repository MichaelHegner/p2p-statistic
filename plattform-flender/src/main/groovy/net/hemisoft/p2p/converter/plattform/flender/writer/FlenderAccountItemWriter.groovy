package net.hemisoft.p2p.converter.plattform.flender.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.plattform.flender.service.FlenderAccountImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractAccountItemWriter

@Slf4j
@Component
class FlenderAccountItemWriter extends AbstractAccountItemWriter {
	FlenderAccountItemWriter(FlenderAccountImportService service) {
		super(service)
	}
}