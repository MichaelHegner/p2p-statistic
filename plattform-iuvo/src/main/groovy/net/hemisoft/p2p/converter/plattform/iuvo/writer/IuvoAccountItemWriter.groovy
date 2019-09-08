package net.hemisoft.p2p.converter.plattform.iuvo.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.plattform.iuvo.service.IuvoAccountImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractAccountItemWriter

@Slf4j
@Component
public class IuvoAccountItemWriter extends AbstractAccountItemWriter {
	 IuvoAccountItemWriter(IuvoAccountImportService service) {
		super(service)
	}
}