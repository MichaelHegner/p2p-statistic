package net.hemisoft.p2p.converter.converter.plattform.twino.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.plattform.twino.service.TwinoAccountImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractAccountItemWriter

@Slf4j
@Component
public class TwinoAccountItemWriter extends AbstractAccountItemWriter {
	 TwinoAccountItemWriter(TwinoAccountImportService service) {
		super(service)
	}
}