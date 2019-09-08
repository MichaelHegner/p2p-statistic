package net.hemisoft.p2p.converter.converter.plattform.debitum.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.converter.converter.plattform.debitum.service.DebitumLoanImportService

@Slf4j
@Component
public class DebitumLoanItemWriter extends AbstractLoanItemWriter {
	 DebitumLoanItemWriter(DebitumLoanImportService service) {
		super(service)
	}
}