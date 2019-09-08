package net.hemisoft.p2p.converter.converter.plattform.swaper.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.plattform.swaper.service.SwaperLoanImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractLoanItemWriter

@Slf4j
@Component
public class SwaperLoanItemWriter extends AbstractLoanItemWriter {
	 SwaperLoanItemWriter(SwaperLoanImportService service) {
		super(service)
	}
}