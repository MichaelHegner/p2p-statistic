package net.hemisoft.p2p.importer.plattform.swaper.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.importer.plattform.swaper.service.SwaperLoanImportService

@Slf4j
@Component
public class SwaperLoanItemWriter extends AbstractLoanItemWriter {
	 SwaperLoanItemWriter(SwaperLoanImportService service) {
		super(service)
	}
}