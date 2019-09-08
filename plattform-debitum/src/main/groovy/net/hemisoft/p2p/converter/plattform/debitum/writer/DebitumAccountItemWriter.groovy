package net.hemisoft.p2p.converter.plattform.debitum.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.plattform.debitum.service.DebitumAccountImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractAccountItemWriter

@Slf4j
@Component
public class DebitumAccountItemWriter extends AbstractAccountItemWriter {
	DebitumAccountItemWriter(DebitumAccountImportService service) {
		super(service)
	}
}