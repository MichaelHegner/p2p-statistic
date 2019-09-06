package net.hemisoft.p2p.importer.plattform.crowdestate.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractAccountItemWriter
import net.hemisoft.p2p.importer.plattform.crowdestate.service.CrowdestateAccountImportService

@Slf4j
@Component
public class CrowdestateAccountItemWriter extends AbstractAccountItemWriter {
	CrowdestateAccountItemWriter(CrowdestateAccountImportService service) {
		super(service)
	}
}