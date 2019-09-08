package net.hemisoft.p2p.converter.plattform.viventor.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.converter.plattform.viventor.service.ViventorLoanImportService

@Slf4j
@Component
public class ViventorLoanItemWriter extends AbstractLoanItemWriter {
	 ViventorLoanItemWriter(ViventorLoanImportService service) {
		super(service)
	}
}