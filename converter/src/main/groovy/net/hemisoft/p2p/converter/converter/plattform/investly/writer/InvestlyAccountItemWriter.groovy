package net.hemisoft.p2p.converter.converter.plattform.investly.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.plattform.investly.service.InvestlyAccountImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractAccountItemWriter

@Slf4j
@Component
public class InvestlyAccountItemWriter extends AbstractAccountItemWriter {
	 InvestlyAccountItemWriter(InvestlyAccountImportService service) {
		super(service)
	}
}