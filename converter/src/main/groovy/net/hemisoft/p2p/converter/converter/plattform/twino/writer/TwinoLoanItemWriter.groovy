package net.hemisoft.p2p.converter.converter.plattform.twino.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.converter.converter.plattform.twino.service.TwinoLoanImportService

@Slf4j
@Component
public class TwinoLoanItemWriter extends AbstractLoanItemWriter {
	 TwinoLoanItemWriter(TwinoLoanImportService service) {
		super(service)
	}
}