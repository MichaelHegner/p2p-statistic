package net.hemisoft.p2p.importer.plattform.debitum.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.importer.plattform.debitum.service.DebitumLoanImportService

@Slf4j
@Component
public class DebitumLoanItemWriter extends AbstractLoanItemWriter {
	 DebitumLoanItemWriter(DebitumLoanImportService service) {
		super(service)
	}
}