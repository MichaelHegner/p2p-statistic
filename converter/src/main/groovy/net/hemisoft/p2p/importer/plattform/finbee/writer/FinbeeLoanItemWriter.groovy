package net.hemisoft.p2p.importer.plattform.finbee.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.importer.plattform.finbee.service.FinbeeLoanImportService

@Slf4j
@Component
public class FinbeeLoanItemWriter extends AbstractLoanItemWriter {
	 FinbeeLoanItemWriter(FinbeeLoanImportService service) {
		super(service)
	}
}