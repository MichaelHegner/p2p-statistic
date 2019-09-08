package net.hemisoft.p2p.converter.plattform.twino.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.plattform.twino.service.TwinoLoanImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractLoanItemWriter

@Slf4j
@Component
public class TwinoLoanItemWriter extends AbstractLoanItemWriter {
	 TwinoLoanItemWriter(TwinoLoanImportService service) {
		super(service)
	}
}