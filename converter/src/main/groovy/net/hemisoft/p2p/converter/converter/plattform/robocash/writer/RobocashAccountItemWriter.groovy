package net.hemisoft.p2p.converter.converter.plattform.robocash.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.writer.AbstractAccountItemWriter
import net.hemisoft.p2p.converter.converter.plattform.robocash.service.RobocashAccountImportService

@Slf4j
@Component
public class RobocashAccountItemWriter extends AbstractAccountItemWriter {
	 RobocashAccountItemWriter(RobocashAccountImportService service) {
		super(service)
	}
}