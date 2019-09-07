package net.hemisoft.p2p.importer.plattform.neofinance.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractAccountItemWriter
import net.hemisoft.p2p.importer.plattform.neofinance.service.NeofinanceAccountImportService

@Slf4j
@Component
public class NeofinanceAccountItemWriter extends AbstractAccountItemWriter {
	NeofinanceAccountItemWriter(NeofinanceAccountImportService service) {
		super(service)
	}
}