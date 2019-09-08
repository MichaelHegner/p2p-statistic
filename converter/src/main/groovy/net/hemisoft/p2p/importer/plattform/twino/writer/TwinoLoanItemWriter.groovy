package net.hemisoft.p2p.importer.plattform.twino.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.importer.plattform.twino.service.TwinoLoanImportService

@Slf4j
@Component
public class TwinoLoanItemWriter extends AbstractLoanItemWriter {
	 TwinoLoanItemWriter(TwinoLoanImportService service) {
		super(service)
	}
}