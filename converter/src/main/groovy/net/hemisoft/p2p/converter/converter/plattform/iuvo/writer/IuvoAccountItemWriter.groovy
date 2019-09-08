package net.hemisoft.p2p.converter.converter.plattform.iuvo.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.writer.AbstractAccountItemWriter
import net.hemisoft.p2p.converter.converter.plattform.iuvo.service.IuvoAccountImportService

@Slf4j
@Component
public class IuvoAccountItemWriter extends AbstractAccountItemWriter {
	 IuvoAccountItemWriter(IuvoAccountImportService service) {
		super(service)
	}
}