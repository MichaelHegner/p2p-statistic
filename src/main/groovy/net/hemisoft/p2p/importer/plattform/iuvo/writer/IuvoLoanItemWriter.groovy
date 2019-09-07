package net.hemisoft.p2p.importer.plattform.iuvo.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.importer.plattform.iuvo.service.IuvoLoanImportService

@Slf4j
@Component
public class IuvoLoanItemWriter extends AbstractLoanItemWriter {
	 IuvoLoanItemWriter(IuvoLoanImportService service) {
		super(service)
	}
}