package net.hemisoft.p2p.converter.converter.plattform.finbee.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.converter.converter.plattform.finbee.service.FinbeeLoanImportService

@Slf4j
@Component
public class FinbeeLoanItemWriter extends AbstractLoanItemWriter {
	 FinbeeLoanItemWriter(FinbeeLoanImportService service) {
		super(service)
	}
}