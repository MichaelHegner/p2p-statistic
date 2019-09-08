package net.hemisoft.p2p.converter.converter.plattform.grupeer.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.plattform.grupeer.service.GrupeerAccountImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractAccountItemWriter

@Slf4j
@Component
public class GrupeerAccountItemWriter extends AbstractAccountItemWriter {
	 GrupeerAccountItemWriter(GrupeerAccountImportService service) {
		super(service)
	}
}