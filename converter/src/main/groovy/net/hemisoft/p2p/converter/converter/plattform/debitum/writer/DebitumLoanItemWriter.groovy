package net.hemisoft.p2p.converter.converter.plattform.debitum.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.plattform.debitum.service.DebitumLoanImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractLoanItemWriter

@Slf4j
@Component
public class DebitumLoanItemWriter extends AbstractLoanItemWriter {
	 DebitumLoanItemWriter(DebitumLoanImportService service) {
		super(service)
	}
}