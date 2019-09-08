package net.hemisoft.p2p.converter.plattform.estateguru.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.plattform.estateguru.service.EstateguruLoanImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractLoanItemWriter

@Slf4j
@Component
class EstateguruLoanItemWriter extends AbstractLoanItemWriter {
	EstateguruLoanItemWriter(EstateguruLoanImportService service) {
		super(service)
	}
}