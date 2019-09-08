package net.hemisoft.p2p.importer.plattform.estateguru.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.importer.plattform.estateguru.service.EstateguruLoanImportService

@Slf4j
@Component
class EstateguruLoanItemWriter extends AbstractLoanItemWriter {
	EstateguruLoanItemWriter(EstateguruLoanImportService service) {
		super(service)
	}
}