package net.hemisoft.p2p.converter.converter.plattform.iuvo.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.plattform.iuvo.service.IuvoLoanImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractLoanItemWriter

@Slf4j
@Component
public class IuvoLoanItemWriter extends AbstractLoanItemWriter {
	 IuvoLoanItemWriter(IuvoLoanImportService service) {
		super(service)
	}
}