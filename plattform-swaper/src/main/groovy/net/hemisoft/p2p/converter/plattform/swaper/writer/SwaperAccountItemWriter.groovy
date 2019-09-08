package net.hemisoft.p2p.converter.plattform.swaper.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.plattform.swaper.service.SwaperAccountImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractAccountItemWriter

@Slf4j
@Component
public class SwaperAccountItemWriter extends AbstractAccountItemWriter {
	 SwaperAccountItemWriter(SwaperAccountImportService service) {
		super(service)
	}
}