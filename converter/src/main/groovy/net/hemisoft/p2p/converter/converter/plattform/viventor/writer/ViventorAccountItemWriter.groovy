package net.hemisoft.p2p.converter.converter.plattform.viventor.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.plattform.viventor.service.ViventorAccountImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractAccountItemWriter

@Slf4j
@Component
public class ViventorAccountItemWriter extends AbstractAccountItemWriter {
	 ViventorAccountItemWriter(ViventorAccountImportService service) {
		super(service)
	}
}