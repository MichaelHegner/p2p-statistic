package net.hemisoft.p2p.converter.plattform.crowdestate.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.plattform.crowdestate.service.CrowdestateAccountImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractAccountItemWriter

@Slf4j
@Component
public class CrowdestateAccountItemWriter extends AbstractAccountItemWriter {
	CrowdestateAccountItemWriter(CrowdestateAccountImportService service) {
		super(service)
	}
}