package net.hemisoft.p2p.converter.plattform.finbee.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.writer.AbstractAccountItemWriter
import net.hemisoft.p2p.converter.plattform.finbee.service.FinbeeAccountImportService

@Slf4j
@Component
public class FinbeeAccountItemWriter extends AbstractAccountItemWriter {
	FinbeeAccountItemWriter(FinbeeAccountImportService service) {
		super(service)
	}
}