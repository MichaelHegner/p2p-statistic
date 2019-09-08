package net.hemisoft.p2p.converter.plattform.neofinance.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.converter.plattform.neofinance.service.NeofinanceLoanImportService

@Slf4j
@Component
public class NeofinanceLoanItemWriter extends AbstractLoanItemWriter {
	NeofinanceLoanItemWriter(NeofinanceLoanImportService service) {
		super(service)
	}
}