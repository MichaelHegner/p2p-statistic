package net.hemisoft.p2p.importer.plattform.debitum.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractAccountItemWriter
import net.hemisoft.p2p.importer.plattform.debitum.service.DebitumAccountImportService

@Slf4j
@Component
public class DebitumAccountItemWriter extends AbstractAccountItemWriter {
	DebitumAccountItemWriter(DebitumAccountImportService service) {
		super(service)
	}
}