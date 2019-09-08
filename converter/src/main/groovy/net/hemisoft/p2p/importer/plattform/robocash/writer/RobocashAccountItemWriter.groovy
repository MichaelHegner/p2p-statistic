package net.hemisoft.p2p.importer.plattform.robocash.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractAccountItemWriter
import net.hemisoft.p2p.importer.plattform.robocash.service.RobocashAccountImportService

@Slf4j
@Component
public class RobocashAccountItemWriter extends AbstractAccountItemWriter {
	 RobocashAccountItemWriter(RobocashAccountImportService service) {
		super(service)
	}
}