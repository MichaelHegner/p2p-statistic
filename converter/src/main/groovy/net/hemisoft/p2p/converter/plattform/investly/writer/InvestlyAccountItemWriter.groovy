package net.hemisoft.p2p.converter.plattform.investly.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.writer.AbstractAccountItemWriter
import net.hemisoft.p2p.converter.plattform.investly.service.InvestlyAccountImportService

@Slf4j
@Component
public class InvestlyAccountItemWriter extends AbstractAccountItemWriter {
	 InvestlyAccountItemWriter(InvestlyAccountImportService service) {
		super(service)
	}
}