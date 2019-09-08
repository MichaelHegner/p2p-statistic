package net.hemisoft.p2p.converter.plattform.investly.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.converter.plattform.investly.service.InvestlyLoanImportService

@Slf4j
@Component
public class InvestlyLoanItemWriter extends AbstractLoanItemWriter {
	 InvestlyLoanItemWriter(InvestlyLoanImportService service) {
		super(service)
	}
}