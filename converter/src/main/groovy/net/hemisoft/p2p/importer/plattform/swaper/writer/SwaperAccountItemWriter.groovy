package net.hemisoft.p2p.importer.plattform.swaper.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractAccountItemWriter
import net.hemisoft.p2p.importer.plattform.swaper.service.SwaperAccountImportService

@Slf4j
@Component
public class SwaperAccountItemWriter extends AbstractAccountItemWriter {
	 SwaperAccountItemWriter(SwaperAccountImportService service) {
		super(service)
	}
}