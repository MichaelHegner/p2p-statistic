package net.hemisoft.p2p.converter.converter.plattform.estateguru.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.converter.converter.plattform.estateguru.service.EstateguruLoanImportService

@Slf4j
@Component
class EstateguruLoanItemWriter extends AbstractLoanItemWriter {
	EstateguruLoanItemWriter(EstateguruLoanImportService service) {
		super(service)
	}
}