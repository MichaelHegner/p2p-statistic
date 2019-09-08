package net.hemisoft.p2p.converter.plattform.neofinance.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.plattform.neofinance.service.NeofinanceAccountImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractAccountItemWriter

@Slf4j
@Component
public class NeofinanceAccountItemWriter extends AbstractAccountItemWriter {
	NeofinanceAccountItemWriter(NeofinanceAccountImportService service) {
		super(service)
	}
}