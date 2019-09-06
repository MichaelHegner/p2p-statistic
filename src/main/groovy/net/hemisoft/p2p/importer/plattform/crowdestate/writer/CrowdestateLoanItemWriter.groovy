package net.hemisoft.p2p.importer.plattform.crowdestate.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.importer.plattform.crowdestate.service.CrowdestateLoanImportService

@Slf4j
@Component
public class CrowdestateLoanItemWriter extends AbstractLoanItemWriter {
	CrowdestateLoanItemWriter(CrowdestateLoanImportService service) {
		super(service)
	}
}