package net.hemisoft.p2p.converter.plattform.grupeer.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.writer.AbstractAccountItemWriter
import net.hemisoft.p2p.converter.plattform.grupeer.service.GrupeerAccountImportService

@Slf4j
@Component
public class GrupeerAccountItemWriter extends AbstractAccountItemWriter {
	 GrupeerAccountItemWriter(GrupeerAccountImportService service) {
		super(service)
	}
}