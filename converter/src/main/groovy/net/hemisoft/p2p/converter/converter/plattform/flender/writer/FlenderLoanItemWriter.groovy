package net.hemisoft.p2p.converter.converter.plattform.flender.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.converter.converter.plattform.flender.service.FlenderLoanImportService

@Slf4j
@Component
public class FlenderLoanItemWriter extends AbstractLoanItemWriter {
	FlenderLoanItemWriter(FlenderLoanImportService service) {
		super(service)
	}
}