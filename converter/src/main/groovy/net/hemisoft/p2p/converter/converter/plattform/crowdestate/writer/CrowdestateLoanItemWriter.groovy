package net.hemisoft.p2p.converter.converter.plattform.crowdestate.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.plattform.crowdestate.service.CrowdestateLoanImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractLoanItemWriter

@Slf4j
@Component
public class CrowdestateLoanItemWriter extends AbstractLoanItemWriter {
	CrowdestateLoanItemWriter(CrowdestateLoanImportService service) {
		super(service)
	}
}