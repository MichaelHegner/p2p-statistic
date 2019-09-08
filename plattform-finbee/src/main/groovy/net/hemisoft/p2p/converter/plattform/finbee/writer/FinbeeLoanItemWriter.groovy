package net.hemisoft.p2p.converter.plattform.finbee.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.plattform.finbee.service.FinbeeLoanImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractLoanItemWriter

@Slf4j
@Component
public class FinbeeLoanItemWriter extends AbstractLoanItemWriter {
	 FinbeeLoanItemWriter(FinbeeLoanImportService service) {
		super(service)
	}
}