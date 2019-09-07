package net.hemisoft.p2p.importer.plattform.finbee.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractAccountItemWriter
import net.hemisoft.p2p.importer.plattform.finbee.service.FinbeeAccountImportService

@Slf4j
@Component
public class FinbeeAccountItemWriter extends AbstractAccountItemWriter {
	FinbeeAccountItemWriter(FinbeeAccountImportService service) {
		super(service)
	}
}