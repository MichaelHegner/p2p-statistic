package net.hemisoft.p2p.importer.plattform.flender.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.importer.plattform.flender.service.FlenderLoanImportService

@Slf4j
@Component
public class FlenderLoanItemWriter extends AbstractLoanItemWriter {
	FlenderLoanItemWriter(FlenderLoanImportService service) {
		super(service)
	}
}