package net.hemisoft.p2p.converter.plattform.twino.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.writer.AbstractAccountItemWriter
import net.hemisoft.p2p.converter.plattform.twino.service.TwinoAccountImportService

@Slf4j
@Component
public class TwinoAccountItemWriter extends AbstractAccountItemWriter {
	 TwinoAccountItemWriter(TwinoAccountImportService service) {
		super(service)
	}
}