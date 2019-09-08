package net.hemisoft.p2p.converter.converter.plattform.flender.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.plattform.flender.service.FlenderLoanImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractLoanItemWriter

@Slf4j
@Component
public class FlenderLoanItemWriter extends AbstractLoanItemWriter {
	FlenderLoanItemWriter(FlenderLoanImportService service) {
		super(service)
	}
}